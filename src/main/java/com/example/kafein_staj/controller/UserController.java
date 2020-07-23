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
import com.example.kafein_staj.service.basket.BasketService;
import com.example.kafein_staj.service.user.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    UserDTO getUser(@PathVariable Long id) throws EntityNotFoundException {
        return userMapper.userToUserDTO(userService.findById(id));
    }

    @GetMapping("/user/{userId}/basket")
    List<BasketDTO> getUserBasketDetails(@PathVariable Long userId) throws EntityNotFoundException {
        return basketService.findByUser_Id(userId);
    }

    @PostMapping("/user/create")
    void registerUser(@RequestBody UserDTO userDto) throws EntityAlreadyExists {
        System.out.println(userDto);
        userService.register(userMapper.userDTOToUser(userDto));
    }

    @PostMapping("/user/{userId}/basket")
    void addItemToBasket(@RequestBody BasketProductDTO basketProductDTO, @PathVariable Long userId) throws EntityAlreadyExists {
        basketService.addItemToBasket(basketProductMapper.basketProductDTOToBasketProduct(basketProductDTO));
    }

    @DeleteMapping("/user/{userId}/basket")
    void deleteItemFromBasket(@RequestBody BasketProductDTO basketProductDTO, @PathVariable Long userId) throws EntityNotFoundException {
        basketService.deleteItemFromBasket(basketProductMapper.basketProductDTOToBasketProduct(basketProductDTO));
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
