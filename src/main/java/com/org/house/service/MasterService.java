package com.org.house.service;

import com.org.house.dto.UserMasterDTO;
import com.org.house.model.Master;
import com.org.house.model.QMaster;
import com.org.house.repository.MasterRepository;
import com.org.house.repository.UserRepository;
import com.org.house.security.SecurityInformation;
import com.org.house.util.UserUtil;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterService {
    private final QMaster qMaster = QMaster.master;
    @Autowired
    private MasterRepository masterRepository;
    @Autowired
    private JPAQueryFactory query;
    @Autowired
    private SecurityInformation securityInformation;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserUtil userUtil;

    public void addMaster(UserMasterDTO userMasterDTO) {
        synchronized (MasterService.class) {
            userRepository.save(userUtil.getMaster(userMasterDTO));
        }
    }

    public Master getMasterById(long id) {
        Master master = query.selectFrom(qMaster).where(qMaster.user_id.eq(id)
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


    public void update(UserMasterDTO userMasterDTO) {
        synchronized (MasterService.class) {
            userRepository.save(userUtil.getMaster(userMasterDTO));
        }
    }

    public void delete(long id) {
        query.delete(qMaster).where(qMaster.user_id.eq(id)
                .and(qMaster.companyId.eq(securityInformation.getUserCompanyId()))).execute();
    }
}
