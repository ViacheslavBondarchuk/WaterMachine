package com.org.house.controller;

import com.org.house.dto.UserDTO;
import com.org.house.model.User;
import com.org.house.service.UserService;
import com.org.house.transfer.New;
import com.org.house.transfer.Update;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Secured("USER")
    @PostMapping
    public void addUser(@Validated(New.class) @RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
    }

    @Secured("USER")
    @PatchMapping
    public User updateUser(@Validated(Update.class) @RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @Secured("ADMIN")
    @GetMapping
    public List<User> getByCompanyId(@RequestParam long companyId) {
        return userService.findByCompanyId(companyId);
    }

    @Secured("ADMIN")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) throws NotFoundException {
        return userService.getUserById(id);
    }

    @Secured("USER")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
    }
}
