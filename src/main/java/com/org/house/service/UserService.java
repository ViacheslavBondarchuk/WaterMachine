package com.org.house.service;

import com.org.house.dto.UserDTO;
import com.org.house.model.Authority;
import com.org.house.model.Master;
import com.org.house.model.Owner;
import com.org.house.model.User;
import com.org.house.repository.MasterRepository;
import com.org.house.repository.OwnerRepository;
import com.org.house.repository.UserRepository;
import com.org.house.security.SecurityInformation;
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
    private UserRepository userRepository;
    private OwnerRepository ownerRepository;
    private MasterRepository masterRepository;
    private SecurityInformation securityInformation;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UserService(UserRepository userRepository, OwnerRepository ownerRepository
            , MasterRepository masterRepository, SecurityInformation securityInformation) {
        this.userRepository = userRepository;
        this.ownerRepository = ownerRepository;
        this.masterRepository = masterRepository;
        this.securityInformation = securityInformation;
    }

    public void addUser(UserDTO userDTO) {
        userDTO.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        userDTO.setEnabled(true);
        userDTO.setAccountNonLocked(true);
        userDTO.setAccountNonExpired(true);
        userDTO.setCredentialsNonExpired(true);
        userDTO.setAuthorities(Collections.singleton(Authority.USER));

        if (userDTO.isOwner()) {
            ownerRepository.save(modelMapper.map(userDTO, Owner.class));
            userRepository.save(modelMapper.map(userDTO, User.class));
        } else if (userDTO.isMaster()) {
            masterRepository.save(modelMapper.map(userDTO, Master.class));
            userRepository.save(modelMapper.map(userDTO, User.class));
        } else {
            userRepository.save(modelMapper.map(userDTO, User.class));
        }
        log.debug("User was added");
    }

    public void updateUser(UserDTO userDTO) {
        User user = userRepository.findByIdAndCompanyId(userDTO.getId(), securityInformation.getUserCompanyId())
                .orElseThrow(
                        () -> new UsernameNotFoundException("User has been not found"));

        if (!user.equals(null)) {
            log.debug(String.format("User by %d has been updated", userDTO.getId()));
            userRepository.save(modelMapper.map(userDTO, User.class));
        }
    }

    public User getUserById(long id) throws NotFoundException {
        return userRepository.findByIdAndCompanyId(id, securityInformation.getUserCompanyId())
                .orElseThrow(
                        () -> new NotFoundException("User`s has beeb not found not found"));
    }

    public List<User> getAllByCompanyId() {
        return userRepository.findByCompanyId(securityInformation.getUserCompanyId());
    }

    public void deleteUserById(long id) {
        log.debug("User was deleted");
        userRepository.deleteById(id);
    }


    //    Method from interface'UserDetailsService'
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User by %s has been not found", username)));
    }

}
