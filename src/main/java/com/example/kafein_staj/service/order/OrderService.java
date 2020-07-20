package com.example.kafein_staj.service.order;

import com.example.kafein_staj.entity.Order;
import com.example.kafein_staj.entity.OrderProduct;
import com.example.kafein_staj.entity.User;
import com.example.kafein_staj.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public interface OrderService {
    Order findById(Long order_id) throws EntityNotFoundException;
    void updateOrderStatus(Order order,String newStatus) throws EntityNotFoundException;
    void deleteById(Long order_id) throws EntityNotFoundException;
    List<Order> getAllOrdersByCustomer(Long customer_id) throws EntityNotFoundException;
    List<OrderProduct> getAllProducts(Long orderId) throws EntityNotFoundException;
}
