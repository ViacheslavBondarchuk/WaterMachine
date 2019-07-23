package com.org.house.service;

import com.org.house.dto.UserDTO;
import com.org.house.model.Authority;
import com.org.house.model.Master;
import com.org.house.model.Owner;
import com.org.house.model.User;
import com.org.house.repository.MasterRepository;
import com.org.house.repository.OwnerRepository;
import com.org.house.repository.UserRepository;
import javassist.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Log4j2
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private MasterRepository masterRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public void addUser(UserDTO userDTO) {
        userDTO.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        userDTO.setEnabled(true);
        userDTO.setAccountNonExpired(true);
        userDTO.setAccountNonExpired(true);
        userDTO.setCredentialsNonExpired(true);

        if (userDTO.isOwner()) {
            userDTO.setAuthorities(Collections.singleton(Authority.OWNER));
            ownerRepository.save(modelMapper.map(userDTO, Owner.class));
        } else if (userDTO.isMaster()) {
            userDTO.setAuthorities(Collections.singleton(Authority.MASTER));
            masterRepository.save(modelMapper.map(userDTO, Master.class));
        } else {
            userDTO.setAuthorities(Collections.singleton(Authority.USER));
        }
        log.info("User was saved");
        userRepository.save(modelMapper.map(userDTO, User.class));
    }

    public User updateUser(UserDTO userDTO) {
        return userRepository.save(new ModelMapper().map(userDTO, User.class));
    }

    public User getUserById(long id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User by " + id + " was not found"));
    }

    public List<User> findByCompanyId(long companyId) {
        return userRepository.findByCompanyId(companyId);
    }

    public void deleteUserById(long id) {
        log.info("User was deleted");
        userRepository.deleteById(id);
    }


    //Method from UserDetailsServrice
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User: " + username + "has been not found"));
    }

}
