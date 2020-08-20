package com.example.kafein_staj.controller;

import com.example.kafein_staj.controller.mapper.UserMapper;
import com.example.kafein_staj.datatransferobject.*;
import com.example.kafein_staj.entity.Role;
import com.example.kafein_staj.entity.UserDetailsImpl;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.exception.IllegalOperationException;
import com.example.kafein_staj.service.user.UserDetailsServiceImpl;
import com.example.kafein_staj.service.user.UserService;
import com.example.kafein_staj.utils.JwtUtil;
import com.example.kafein_staj.utils.PrincipalUtil;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    private AuthenticationManager authenticationManager;
    private UserDetailsServiceImpl userDetailsService;
    private JwtUtil jwtUtil;
    private PrincipalUtil principalUtil;

    @Autowired
    public UserController(
            UserService userService,
            AuthenticationManager authenticationManager,
            UserDetailsServiceImpl userDetailsService,
            JwtUtil jwtUtil,
            PrincipalUtil principalUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.principalUtil = principalUtil;
    }

    @PostMapping("/signin")
    AuthenticationResponse login(@RequestBody AuthenticationRequest request) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect email or password", e);
        }

        UserDetailsImpl userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String jwt = jwtUtil.generateToken(userDetails);
        return new AuthenticationResponse(jwt);
    }

    @GetMapping("/user")
    UserDTO getUser(){
        Long userId = principalUtil.getPrincipalId();
        try {
            return userMapper.userToUserDTO(userService.findById(userId));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + userId + " does not exist");
        }
    }

    @GetMapping("/users")
    List<UserDTO> getUsersByRole(@RequestParam Role role){
        return userMapper.userToDto(userService.getAllUsersByRole(role));
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    UserDTO registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        try {
            return userMapper.userToUserDTO(userService.register(userMapper.registerDTOToUser(userRegisterDTO)));
        } catch (EntityAlreadyExists entityAlreadyExists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with same email or phone number already exists");
        }
    }

    @DeleteMapping("/user")
    void deleteUser() {
        Long userId = principalUtil.getPrincipalId();
        try {
            userService.deleteUserById(userId);
        } catch (EntityNotFoundException | IllegalOperationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User already deleted");
        }
    }

    @PatchMapping("/user")
    void updateUser(@RequestBody UserDTO userDto){
        Long userId = principalUtil.getPrincipalId();
        try {
            userService.update(userMapper.userDTOToUser(userDto), userId);
        } catch (EntityAlreadyExists entityAlreadyExists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with same email or phone number already exists");
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + userId + " does not exist");
        }
    }
}
