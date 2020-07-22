package com.example.kafein_staj.controller;

import com.example.kafein_staj.controller.mapper.UserMapper;
import com.example.kafein_staj.datatransferobject.UserDTO;
import com.example.kafein_staj.entity.User;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.service.user.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserService userService;
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    UserDTO getUser(@PathVariable Long id) throws EntityNotFoundException {
        return userMapper.userToUserDTO(userService.findById(id));
    }

    @PostMapping("/user/create")
    void registerUser(@RequestBody UserDTO userDto) throws EntityAlreadyExists {
        System.out.println(userDto);
        userService.register(userMapper.userDTOToUser(userDto));
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) throws EntityNotFoundException {
        userService.deleteById(id);
    }

    @PatchMapping("/user/{id}")
    void updateUser(@RequestBody UserDTO userDto, @PathVariable Long id) throws EntityNotFoundException, EntityAlreadyExists {
        userService.update(userMapper.userDTOToUser(userDto), id);
    }
}
