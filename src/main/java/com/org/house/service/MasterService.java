package com.org.house.service;

import com.org.house.dto.MasterDTO;
import com.org.house.model.Master;
import com.org.house.model.QMaster;
import com.org.house.repository.MasterRepository;
import com.org.house.security.SecurityInformation;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class MasterService {
    private final QMaster qMaster = QMaster.master;
    @Autowired
    private MasterRepository masterRepository;
    @Autowired
    private SecurityInformation securityInformation;
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private JPAQueryFactory query;

    public Master getMasterById(long id) {
        Master master = query.selectFrom(qMaster).where(qMaster.id.eq(id)
                .and(qMaster.companyId.eq(securityInformation.getUserCompanyId()))).fetchOne();
        if (master == null) {
            throw new UsernameNotFoundException("Master has been not found");
        }
        return master;
    }

    public List<Master> getAllMasterByCompanyId(long id) {
        return masterRepository.findAllByCompanyId(id)
                .orElseThrow(
                        () -> new UsernameNotFoundException(String.format(
                                "Masters by: %d company id has been not found", id)));
    }


    public void update(MasterDTO masterDTO) {
        Master master = query.selectFrom(qMaster).where(qMaster.id.eq(masterDTO.getId())
                .and(qMaster.companyId.eq(securityInformation.getUserCompanyId()))).fetchOne();
        if (master == null) {
            throw new UsernameNotFoundException("Master has been not found");
        }
        log.debug("Master was updated");
        masterRepository.save(modelMapper.map(masterDTO, Master.class));
    }

    public void delete(long id) {
        log.debug("Master has been deleted");
        query.delete(qMaster).where(qMaster.id.eq(id)
                .and(qMaster.companyId.eq(securityInformation.getUserCompanyId()))).execute();
    }
}
