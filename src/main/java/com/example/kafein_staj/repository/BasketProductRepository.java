package com.example.kafein_staj.repository;

import com.example.kafein_staj.entity.BasketProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BasketProductRepository extends CrudRepository<BasketProduct, Long> {
    Optional<List<BasketProduct>> findAllByBasket_BasketId(Long basket_basketId);
}
