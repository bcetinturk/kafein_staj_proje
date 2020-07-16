package com.example.kafein_staj.repository;

import com.example.kafein_staj.entity.Order;
import com.example.kafein_staj.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findAllByUserId(Long user_id);
    Optional<Order> findByOrderNo(Long orderNo);
}
