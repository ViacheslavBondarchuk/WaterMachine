package com.org.house.service;

import java.util.List;

import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.org.house.dto.UserDTO;
import com.org.house.model.User;
import com.org.house.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(UserDTO userDTO) {
        return userRepository.save(new ModelMapper().map(userDTO, User.class));
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User updateUser(UserDTO userDTO) {
        return userRepository.saveAndFlush(new ModelMapper().map(userDTO, User.class));
    }

    public User getUserById(long id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User by " + id + " was not found"));
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User: " + username + "has been not found"));
    }
}
