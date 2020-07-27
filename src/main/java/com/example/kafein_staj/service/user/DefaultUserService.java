package com.example.kafein_staj.service.user;

import com.example.kafein_staj.entity.Basket;
import com.example.kafein_staj.entity.User;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.repository.BasketRepository;
import com.example.kafein_staj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService{
    //TODO: Should add a logger
    UserRepository userRepository;
    BasketRepository basketRepository;

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
    public void register(User user) throws EntityAlreadyExists {
        try {
            userRepository.save(user);
            Basket basket = new Basket(); // create a basket for user
            basket.setUser(user);
            basketRepository.save(basket);
        } catch (DataIntegrityViolationException e) {
            throw new EntityAlreadyExists("Same user with email or phone number exists");
        }
    }

    @Override
    public void update(User updatedUser, Long id) throws EntityAlreadyExists, EntityNotFoundException {
        try {
            userRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("User with id " + id + " does not exist"));

            updatedUser.setId(id);
            userRepository.save(updatedUser);

        } catch (DataIntegrityViolationException e) {
            throw new EntityAlreadyExists("Same user with email or phone number exists");
        }
    }

    @Override
    public void deleteById(Long userId) throws EntityNotFoundException {
        try {
            userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("This user already does not exist");
        }
    }
}
