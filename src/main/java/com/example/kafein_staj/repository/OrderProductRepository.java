package com.example.kafein_staj.repository;

import com.example.kafein_staj.entity.OrderProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {
    List<OrderProduct> findAllByOrder_OrderId(Long order_orderId);
}
