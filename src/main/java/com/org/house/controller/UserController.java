package com.org.house.controller;

import com.org.house.dto.UserDTO;
import com.org.house.model.User;
import com.org.house.service.UserService;
import com.org.house.transfer.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public void addUser(@Validated({NewUser.class, NewMaster.class
            , NewOwner.class}) @RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
    }

    @PatchMapping
    public void updateUser(@Validated({UpdateOwner.class, UpdateMaster.class
            , UpdateUser.class}) @RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
    }

    @GetMapping
    public List<User> getUserByCompanyId() {
        return userService.getAllByCompanyId();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
    }
}
