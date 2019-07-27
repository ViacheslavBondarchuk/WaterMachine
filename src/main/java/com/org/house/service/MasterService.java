package com.org.house.service;

import com.org.house.dto.MasterDTO;
import com.org.house.model.Master;
import com.org.house.repository.MasterRepository;
import com.org.house.security.SecurityInformation;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class MasterService {
    @Autowired
    private MasterRepository masterRepository;
    @Autowired
    private SecurityInformation securityInformation;
    private ModelMapper modelMapper = new ModelMapper();

    public Master getMasterByIdAndCompanyId(long id) {
        return masterRepository.findByIdAndCompanyId(id, securityInformation.getUserCompanyId())
                .orElseThrow(
                        () -> new UsernameNotFoundException("Master has been not found"));
    }

    public List<Master> getAllMasterByCompanyId(long id) {
        return masterRepository.findAllByCompanyId(id)
                .orElseThrow(
                        () -> new UsernameNotFoundException(String.format(
                                "Masters by: %d company id has been not found", id)));
    }


    public void update(MasterDTO masterDTO) {
        Master master = masterRepository.findById(masterDTO.getCompanyId())
                .orElseThrow(
                        () -> new UsernameNotFoundException(
                                String.format("Master by: %d has been not found", masterDTO.getCompanyId())));

        if (!master.equals(null)) {
            log.debug("Master has been updated");
            masterRepository.save(modelMapper.map(masterDTO, Master.class));
        }
    }

    public void delete(long id) {
        log.debug("Master has been deleted");
        masterRepository.deleteByIdAndCompanyId(id, securityInformation.getUserCompanyId());
    }
}
