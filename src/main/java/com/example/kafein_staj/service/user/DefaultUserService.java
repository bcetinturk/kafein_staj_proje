package com.example.kafein_staj.service.user;

import com.example.kafein_staj.controller.mapper.UserMapper;
import com.example.kafein_staj.entity.Basket;
import com.example.kafein_staj.entity.Role;
import com.example.kafein_staj.entity.User;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.exception.IllegalOperationException;
import com.example.kafein_staj.repository.BasketRepository;
import com.example.kafein_staj.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService implements UserService{
    //TODO: Should add a logger
    UserRepository userRepository;
    BasketRepository basketRepository;
    UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    public DefaultUserService(UserRepository userRepository, BasketRepository basketRepository) {
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
    }

    @Override
    public User findById(Long userId) throws EntityNotFoundException{
        return userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User with id " + userId + " does not exist"));

    }

    @Override
    public User register(User user) throws EntityAlreadyExists {
        try {
            user.setRole(Role.CUSTOMER);    // /user/create  yeni müşteriler için, buradan admin kaydı yapılamaz
            user = userRepository.save(user);
            Basket basket = new Basket(); // müşteri için sepet yarat
            basket.setUser(user);
            basketRepository.save(basket);
            return user;
        } catch (DataIntegrityViolationException e) {
            throw new EntityAlreadyExists("Same user with email or phone number exists");
        }
    }

    @Override
    public void update(User updatedUser, Long id) throws EntityAlreadyExists, EntityNotFoundException {
        try {
            User user = userRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("User with id " + id + " does not exist"));

            updatedUser.setId(id);
            updatedUser.setPassword(user.getPassword()); //
            updatedUser.setRole(user.getRole());  // önceden rolü neyse şimdi de aynı
            userRepository.save(updatedUser);

        } catch (DataIntegrityViolationException e) {
            throw new EntityAlreadyExists("Same user with email or phone number exists");
        }
    }

    @Override
    public void deleteUserById(Long userId) throws EntityNotFoundException, IllegalOperationException {
        deleteById(userId, Role.CUSTOMER);
    }

    @Override
    public void deleteAdminById(Long userId) throws EntityNotFoundException, IllegalOperationException {
        Integer adminCount = userRepository.countByRole(Role.ADMIN);
        if(adminCount > 1) {
            deleteById(userId, Role.ADMIN);
        } else {
            throw new IllegalOperationException("");
        }

    }

    private void deleteById(Long userId, Role role) throws IllegalOperationException, EntityNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(""));

        if(user.getRole().equals(role)) {
            userRepository.deleteById(userId);
        } else {
            throw new IllegalOperationException("");
        }
    }

    @Override
    public List<User> getAllUsersByRole(Role role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    public void registerAdmin(User user) {
        user.setRole(Role.ADMIN);
        userRepository.save(user);  // adminin sepete ihtiyacı yok
    }
}
