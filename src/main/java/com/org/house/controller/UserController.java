package com.org.house.controller;

import com.org.house.entity.User;
import com.org.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/user/all")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @DeleteMapping("/user/delete")
    public void deleteUser(@RequestParam(value = "id") long id){
        userService.deleteUser(id);
    }
}
