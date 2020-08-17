package com.example.kafein_staj.controller;

import com.example.kafein_staj.controller.mapper.BasketProductMapper;
import com.example.kafein_staj.controller.mapper.UserMapper;
import com.example.kafein_staj.datatransferobject.*;
import com.example.kafein_staj.entity.Role;
import com.example.kafein_staj.entity.UserDetailsImpl;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.exception.IllegalOperationException;
import com.example.kafein_staj.exception.NotEnoughStockException;
import com.example.kafein_staj.service.basket.BasketService;
import com.example.kafein_staj.service.user.UserDetailsServiceImpl;
import com.example.kafein_staj.service.user.UserService;
import com.example.kafein_staj.utils.JwtUtil;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    public UserController(UserService userService, BasketService basketService) {
        this.userService = userService;
        this.basketService = basketService;
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
        Long userId = getPrincipalId();
        try {
            return userMapper.userToUserDTO(userService.findById(userId));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + userId + " does not exist");
        }
    }

    @GetMapping("/user/basket")
    List<BasketDTO> getUserBasketDetails(){
        Long userId = getPrincipalId();
        try {
            return basketService.findByUser_Id(userId);
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

    @PostMapping("/user/basket")
    void addItemToBasket(@RequestBody BasketProductDTO basketProductDTO) {
        Long userId = getPrincipalId();
        try {
            System.out.println(basketProductDTO);
            basketService.addItemToBasket(basketProductMapper.basketProductDTOToBasketProduct(basketProductDTO), userId);
        } catch (EntityAlreadyExists entityAlreadyExists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item(s) already added to basket");
        } catch (NotEnoughStockException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not add item more than in the stock");
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product with id " + basketProductDTO.getProductId() + " or user with id " + userId + " does not exist");
        } catch (IllegalOperationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not add item(s) less than zero");
        }
    }

    @DeleteMapping("/user/basket")
    void deleteItemFromBasket(@RequestBody BasketProductDTO basketProductDTO) {
        Long userId = getPrincipalId();
        try {
            basketService.deleteItemFromBasket(basketProductMapper.basketProductDTOToBasketProduct(basketProductDTO), userId);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item already deleted or user does not exist");
        }
    }

    @DeleteMapping("/user")
    void deleteUser() {
        Long userId = getPrincipalId();
        try {
            userService.deleteById(userId);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User already deleted");
        }
    }

    @PatchMapping("/user")
    void updateUser(@RequestBody UserDTO userDto){
        Long userId = getPrincipalId();
        try {
            userService.update(userMapper.userDTOToUser(userDto), userId);
        } catch (EntityAlreadyExists entityAlreadyExists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with same email or phone number already exists");
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + userId + " does not exist");
        }
    }

    private Long getPrincipalId() {
        return ((UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }
}
