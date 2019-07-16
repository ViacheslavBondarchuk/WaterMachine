package com.org.house.controller;

import java.util.List;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.house.dto.UserDTO;
import com.org.house.model.User;
import com.org.house.service.UserService;
import com.org.house.transfer.New;
import com.org.house.transfer.Update;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@Validated(New.class) @RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @PutMapping
    public User updateUser(@Validated(Update.class) @RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) throws NotFoundException {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
    }
}
