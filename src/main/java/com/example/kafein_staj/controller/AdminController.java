package com.example.kafein_staj.controller;

import com.example.kafein_staj.controller.mapper.UserMapper;
import com.example.kafein_staj.datatransferobject.UserDTO;
import com.example.kafein_staj.datatransferobject.UserRegisterDTO;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.exception.IllegalOperationException;
import com.example.kafein_staj.service.user.UserService;
import com.example.kafein_staj.utils.PrincipalUtil;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")   //  /admin sadece adminler tarafından erişilebilir
public class AdminController {

    UserService userService;
    PrincipalUtil principalUtil;
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    public AdminController(UserService userService, PrincipalUtil principalUtil) {
        this.userService = userService;
        this.principalUtil = principalUtil;
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    void newAdmin(@RequestBody UserRegisterDTO userRegisterDTO) {
        userService.registerAdmin(userMapper.registerDTOToUser(userRegisterDTO));
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) throws EntityNotFoundException, IllegalOperationException {
        userService.deleteUserById(id);
    }

    @DeleteMapping("/{id}")
    void deleteAdmin(@PathVariable Long id) throws EntityNotFoundException, IllegalOperationException {
        userService.deleteAdminById(id);
    }

    @GetMapping("")
    UserDTO getAdminDetails() throws EntityNotFoundException {
        Long userId = principalUtil.getPrincipalId();
        return userMapper.userToUserDTO(userService.findById(userId));
    }

    @PatchMapping("")
    void updateAdmin(@RequestBody UserDTO userDTO) throws EntityNotFoundException, EntityAlreadyExists {
        Long userId = principalUtil.getPrincipalId();
        userService.update(userMapper.userDTOToUser(userDTO), userId);
    }
}
