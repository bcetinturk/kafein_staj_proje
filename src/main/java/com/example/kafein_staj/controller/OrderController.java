package com.example.kafein_staj.controller;

import com.example.kafein_staj.controller.mapper.OrderMapper;
import com.example.kafein_staj.datatransferobject.OrderDTO;
import com.example.kafein_staj.datatransferobject.ProductDTO;
import com.example.kafein_staj.datatransferobject.UserDTO;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.exception.IllegalOperationException;
import com.example.kafein_staj.repository.OrderRepository;
import com.example.kafein_staj.service.order.OrderService;
import com.fasterxml.jackson.databind.node.TextNode;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    private OrderService orderService;
    private OrderMapper orderMapper= Mappers.getMapper(OrderMapper.class);

    @Autowired
    public OrderController(OrderService orderService) {this.orderService = orderService; }

    @GetMapping("/order/{order_id}")
    OrderDTO getOrder(@PathVariable Long order_id) throws EntityNotFoundException, IllegalOperationException {
        return orderMapper.makeDTOFromOrder(orderService.findById(order_id));
    }

    @PostMapping("/order/new")
    OrderDTO placeNewOrder() throws EntityNotFoundException {
        return orderMapper.makeDTOFromOrder(orderService.newOrder());
    }

    @DeleteMapping("/order/{order_id}")
    void deleteOrder(@PathVariable Long order_id) throws EntityNotFoundException, IllegalOperationException {
        orderService.deleteById(order_id);
    }

    @PatchMapping("/order/{order_id}/status")   // adminler için
    OrderDTO updateOrder(@PathVariable Long order_id, @RequestBody OrderDTO newStatus) throws EntityNotFoundException, IllegalOperationException {
        return orderMapper.makeDTOFromOrder(orderService.updateOrderStatus(order_id, newStatus));
    }

    @PatchMapping("/order/{orderId}")        // müşterinin siparişini iptal etmesi için
    void cancelledOrder(@PathVariable Long orderId) throws EntityNotFoundException, IllegalOperationException {
        orderService.cancelledOrder(orderId);
    }
}
