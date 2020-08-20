package com.example.kafein_staj.service.user;

import com.example.kafein_staj.datatransferobject.UserDTO;
import com.example.kafein_staj.entity.Role;
import com.example.kafein_staj.entity.User;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.exception.IllegalOperationException;

import java.util.List;

public interface UserService {
    User findById(Long userId) throws EntityNotFoundException;
    User register(User user) throws EntityAlreadyExists;
    void update(User user, Long id) throws EntityAlreadyExists, EntityNotFoundException;
    void deleteUserById(Long userId) throws EntityNotFoundException, IllegalOperationException;
    void deleteAdminById(Long userId) throws EntityNotFoundException, IllegalOperationException;
    List<User> getAllUsersByRole(Role role);
    void registerAdmin(User user);
}
