package com.example.kafein_staj.controller;

import com.example.kafein_staj.controller.mapper.BasketProductMapper;
import com.example.kafein_staj.datatransferobject.BasketDTO;
import com.example.kafein_staj.datatransferobject.BasketProductDTO;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.exception.IllegalOperationException;
import com.example.kafein_staj.exception.NotEnoughStockException;
import com.example.kafein_staj.service.basket.BasketService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class BasketController {
    private BasketService basketService;
    private BasketProductMapper basketProductMapper = Mappers.getMapper(BasketProductMapper.class);

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/user/basket")
    List<BasketDTO> getUserBasketDetails() throws EntityNotFoundException {
        return basketService.findByUser_Id();
    }

    @PostMapping("/user/basket")
    void addItemToBasket(@RequestBody BasketProductDTO basketProductDTO) {
        try {
            System.out.println(basketProductDTO);
            basketService.addItemToBasket(basketProductMapper.basketProductDTOToBasketProduct(basketProductDTO));
        } catch (EntityAlreadyExists entityAlreadyExists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item(s) already added to basket");
        } catch (NotEnoughStockException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not add item more than in the stock");
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product with id " + basketProductDTO.getProductId() + " does not exist");
        } catch (IllegalOperationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not add item(s) less than zero");
        }
    }

    @DeleteMapping("/user/basket")
    void deleteItemFromBasket(@RequestBody BasketProductDTO basketProductDTO) {
        try {
            basketService.deleteItemFromBasket(basketProductMapper.basketProductDTOToBasketProduct(basketProductDTO));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item already deleted or user does not exist");
        }
    }
}
