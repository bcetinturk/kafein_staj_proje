package com.example.kafein_staj.repository;

import com.example.kafein_staj.entity.Basket;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BasketRepository extends CrudRepository<Basket, Long> {
    Optional<Basket> findByUser_Id(Long user_id);
    Optional<Basket> findById(Long id);
}
