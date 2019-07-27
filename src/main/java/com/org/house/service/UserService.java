package com.org.house.service;

import com.org.house.dto.UserDTO;
import com.org.house.model.Authority;
import com.org.house.model.User;
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

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SecurityInformation securityInformation;
    private ModelMapper modelMapper = new ModelMapper();

    public void addUser(UserDTO userDTO) {
        userDTO.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        userDTO.setEnabled(true);
        userDTO.setAccountNonLocked(true);
        userDTO.setAccountNonExpired(true);
        userDTO.setCredentialsNonExpired(true);
        userDTO.setAuthorities(Collections.singleton(Authority.USER));

        log.debug("User was added");
        userRepository.save(modelMapper.map(userDTO, User.class));
    }

    public void updateUser(UserDTO userDTO) {
        User user = userRepository.findByIdAndCompanyId(userDTO.getId(), securityInformation.getUserCompanyId())
                .orElseThrow(
                        () -> new UsernameNotFoundException("User has been not found"));

        if (!user.equals(null)) {
            log.debug(String.format("User by %d has been updated",userDTO.getId()));
            userRepository.save(modelMapper.map(userDTO, User.class));
        }
    }

    public User getUserById(long id) throws NotFoundException {
        return userRepository.findByIdAndCompanyId(id, securityInformation.getUserCompanyId())
                .orElseThrow(
                        () -> new NotFoundException("User by " + id + " was not found"));
    }

    public List<User> getAllByCompanyId(long companyId) {
        return userRepository.findByCompanyId(companyId);
    }

    public void deleteUserById(long id) {
        log.debug("User was deleted");
        userRepository.deleteById(id);
    }


    //    Method from interface'UserDetailsService'
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User: " + username + "has been not found"));
    }

}
