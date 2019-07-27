package com.org.house.controller;

import com.org.house.dto.UserDTO;
import com.org.house.model.User;
import com.org.house.service.UserService;
import com.org.house.transfer.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("permitAll()")
    @PostMapping
    public void addUser(@Validated({NewOwner.class, NewMaster.class
            , NewUser.class}) @RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
    }

    @PreAuthorize("permitAll()")
    @PatchMapping
    public void updateUser(@Validated({UpdateOwner.class, UpdateMaster.class
            , UpdateUser.class}) @RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
    }

    @Secured("ADMIN,OWNER")
    @GetMapping
    public List<User> getUserByCompanyId() {
        return userService.getAllByCompanyId();
    }

    @Secured("ADMIN")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) throws NotFoundException {
        return userService.getUserById(id);
    }

    @Secured("USER,ADMIN")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
    }
}
