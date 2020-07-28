package com.example.kafein_staj.service.order;

import com.example.kafein_staj.datatransferobject.OrderDTO;
import com.example.kafein_staj.entity.Order;
import com.example.kafein_staj.entity.OrderProduct;
import com.example.kafein_staj.entity.User;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.exception.IllegalOperationException;
import com.fasterxml.jackson.databind.node.TextNode;

import java.util.ArrayList;
import java.util.List;

public interface OrderService {
    Order findById(Long order_id) throws EntityNotFoundException;
    Order updateOrderStatus(Long order_id, OrderDTO newStatus) throws EntityNotFoundException, IllegalOperationException;
    void deleteById(Long order_id) throws EntityNotFoundException;
    List<Order> getAllOrdersByCustomer(Long customer_id) throws EntityNotFoundException;
    List<OrderProduct> getAllProducts(Long orderId) throws EntityNotFoundException;
    void changeQuantity(Order order);
    void cancelledOrder(Order order) throws EntityNotFoundException;
    Order newOrder(Long userId) throws EntityNotFoundException;
}
