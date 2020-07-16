package com.example.kafein_staj.repository;

import com.example.kafein_staj.entity.Order;
import com.example.kafein_staj.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findAllByUser(User user);
}
