package com.example.kafein_staj.controller;

import com.example.kafein_staj.controller.mapper.BasketProductMapper;
import com.example.kafein_staj.controller.mapper.UserMapper;
import com.example.kafein_staj.datatransferobject.BasketDTO;
import com.example.kafein_staj.datatransferobject.BasketProductDTO;
import com.example.kafein_staj.datatransferobject.UserDTO;
import com.example.kafein_staj.entity.Basket;
import com.example.kafein_staj.entity.User;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.exception.NotEnoughStockException;
import com.example.kafein_staj.service.basket.BasketService;
import com.example.kafein_staj.service.user.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;
    private BasketService basketService;
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private BasketProductMapper basketProductMapper = Mappers.getMapper(BasketProductMapper.class);

    @Autowired
    public UserController(UserService userService, BasketService basketService) {
        this.userService = userService;
        this.basketService = basketService;
    }

    @GetMapping("/user/{id}")
    UserDTO getUser(@PathVariable Long id){
        try {
            return userMapper.userToUserDTO(userService.findById(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + id + " does not exist");
        }
    }

    @GetMapping("/user/{userId}/basket")
    List<BasketDTO> getUserBasketDetails(@PathVariable Long userId){
        try {
            return basketService.findByUser_Id(userId);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + userId + " does not exist");
        }
    }

    @PostMapping("/user/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    void registerUser(@RequestBody UserDTO userDto) {
        System.out.println(userDto);
        try {
            userService.register(userMapper.userDTOToUser(userDto));
        } catch (EntityAlreadyExists entityAlreadyExists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with same email or phone number already exists");
        }
    }

    @PostMapping("/user/{userId}/basket")
    void addItemToBasket(@RequestBody BasketProductDTO basketProductDTO, @PathVariable Long userId) {
        try {
            System.out.println(basketProductDTO);
            basketService.addItemToBasket(basketProductMapper.basketProductDTOToBasketProduct(basketProductDTO));
        } catch (EntityAlreadyExists entityAlreadyExists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item(s) already added to basket");
        } catch (NotEnoughStockException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not add item more than in the stock");
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No item with " + basketProductDTO.getProduct_id() + " was found");
        }
    }

    @DeleteMapping("/user/{userId}/basket")
    void deleteItemFromBasket(@RequestBody BasketProductDTO basketProductDTO, @PathVariable Long userId) {
        try {
            basketService.deleteItemFromBasket(basketProductMapper.basketProductDTOToBasketProduct(basketProductDTO));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item already deleted or user does not exist");
        }
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) {
        try {
            userService.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User already deleted");
        }
    }

    @PatchMapping("/user/{id}")
    void updateUser(@RequestBody UserDTO userDto, @PathVariable Long id){
        try {
            userService.update(userMapper.userDTOToUser(userDto), id);
        } catch (EntityAlreadyExists entityAlreadyExists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with same email or phone number already exists");
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + id + " does not exist");
        }
    }
}
