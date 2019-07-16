package com.org.house.service;

import com.org.house.dto.UserDTO;
import com.org.house.model.Authority;
import com.org.house.model.User;
import com.org.house.repository.UserRepository;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(UserDTO userDTO) {
        userDTO.setEnabled(true);
        userDTO.setAccountNonExpired(true);
        userDTO.setAccountNonExpired(true);
        userDTO.setCredentialsNonExpired(true);
        userDTO.setAuthorities(Collections.singleton(Authority.USER));

        return userRepository.save(new ModelMapper().map(userDTO, User.class));
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User updateUser(UserDTO userDTO) {
        return userRepository.save(new ModelMapper().map(userDTO, User.class));
    }

    public User getUserById(long id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User by " + id + " was not found"));
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User: " + username + "has been not found"));
    }
}
