package com.example.kafein_staj.service.user;

import com.example.kafein_staj.entity.User;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;

public interface UserService {
    User findById(Long userId) throws EntityNotFoundException;
    void register(User user) throws EntityAlreadyExists;
    void update(User user, Long id) throws EntityAlreadyExists, EntityNotFoundException;
    void deleteById(Long userId) throws EntityNotFoundException;
}
