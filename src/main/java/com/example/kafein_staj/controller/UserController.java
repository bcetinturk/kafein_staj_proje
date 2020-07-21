package com.example.kafein_staj.controller;

import com.example.kafein_staj.entity.User;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    User getUSer(@PathVariable Long id) throws EntityNotFoundException {
        return userService.findById(id);
    }

    @PostMapping("/user/create")
    void registerUser(@RequestBody User user) throws EntityAlreadyExists {
        System.out.println(user);
        userService.register(user);
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) throws EntityNotFoundException {
        userService.deleteById(id);
    }

    @PatchMapping("/user/{id}")
    void updateUser(@RequestBody User user, @PathVariable Long id) throws EntityNotFoundException, EntityAlreadyExists {
        userService.update(user, id);
    }
}
