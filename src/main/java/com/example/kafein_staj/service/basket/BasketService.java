package com.example.kafein_staj.service.basket;

import com.example.kafein_staj.entity.Basket;
import com.example.kafein_staj.entity.BasketProduct;
import com.example.kafein_staj.exception.EntityNotFoundException;

import java.util.List;

public interface BasketService {
    Basket findById(Long id) throws EntityNotFoundException;
    Basket findByUser_Id(Long id) throws EntityNotFoundException;
    List<BasketProduct> getAllProductsById(Long id) throws EntityNotFoundException;
}
