package com.example.kafein_staj.service.basket;

import com.example.kafein_staj.datatransferobject.BasketDTO;
import com.example.kafein_staj.entity.Basket;
import com.example.kafein_staj.entity.BasketProduct;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.exception.IllegalOperationException;
import com.example.kafein_staj.exception.NotEnoughStockException;

import java.util.List;

public interface BasketService {
    Basket findById(Long id) throws EntityNotFoundException;
    List<BasketDTO> findByUser_Id() throws EntityNotFoundException;
    List<BasketProduct> getAllProductsById(Long id) throws EntityNotFoundException;
    void addItemToBasket(BasketProduct basketProduct) throws EntityAlreadyExists, NotEnoughStockException, EntityNotFoundException, IllegalOperationException;
    void deleteItemFromBasket(Long productId) throws EntityNotFoundException;
}
