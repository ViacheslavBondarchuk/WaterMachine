package com.org.house.service;

import com.org.house.dto.OwnerDTO;
import com.org.house.model.Owner;
import com.org.house.repository.OwnerRepository;
import javassist.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public void updateOwner(OwnerDTO ownerDTO) {
        Owner owner = ownerRepository.findById(ownerDTO.getId())
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("Owner by: %d has been not found", ownerDTO.getId())));

        if (owner != null) {
            log.debug("Owner has been updated");
            ownerRepository.save(modelMapper.map(ownerDTO, Owner.class));
        }
    }

    public Owner getOwnerById(long id) throws NotFoundException {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Owner has been not found"));
    }

    public List<Owner> getAllOwner() {
        return ownerRepository.findAll();
    }

    public void deleteById(long id) {
        log.debug(String.format("Owner by %d has been deleted", id));
        ownerRepository.deleteById(id);
    }
}
