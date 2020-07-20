package com.example.kafein_staj.service.basket;

import com.example.kafein_staj.entity.Basket;
import com.example.kafein_staj.exception.EntityNotFoundException;

public interface BasketService {
    Basket findById(Long id) throws EntityNotFoundException;
    Basket findByUser_Id(Long id) throws EntityNotFoundException;
}
