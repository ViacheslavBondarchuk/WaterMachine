package com.org.house.service;

import com.org.house.dto.UserOwnerDTO;
import com.org.house.model.Owner;
import com.org.house.repository.OwnerRepository;
import com.org.house.repository.UserRepository;
import com.org.house.util.UserUtil;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserUtil userUtil;

    public void addOwner(UserOwnerDTO userOwnerDTO) {
        synchronized (OwnerService.class) {
            userRepository.save(userUtil.getOwner(userOwnerDTO));
        }
    }

    public void updateOwner(UserOwnerDTO userOwnerDTO) {
        synchronized (OwnerService.class) {
            userRepository.save(userUtil.getOwner(userOwnerDTO));
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
        ownerRepository.deleteById(id);
    }
}
