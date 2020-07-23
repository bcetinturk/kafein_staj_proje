package com.example.kafein_staj.controller;

import com.example.kafein_staj.controller.mapper.OrderMapper;
import com.example.kafein_staj.datatransferobject.OrderDTO;
import com.example.kafein_staj.datatransferobject.ProductDTO;
import com.example.kafein_staj.datatransferobject.UserDTO;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.service.order.OrderService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    private OrderService orderService;
    private OrderMapper orderMapper= Mappers.getMapper(OrderMapper.class);

    @Autowired
    public OrderController(OrderService orderService) {this.orderService = orderService; }



    @GetMapping("/order/{id}")
    OrderDTO getProduct(@PathVariable Long order_id) throws EntityNotFoundException {
        return orderMapper.makeDTOFromOrder(orderService.findById(order_id));
    }

    @DeleteMapping("/order/{id}")
    void deleteProduct(@PathVariable Long order_id) throws EntityNotFoundException {
        orderService.deleteById(order_id);

    }

    @PatchMapping("/order/{id}")
    void updateOrder(@RequestBody OrderDTO orderDTO, @PathVariable String newStatus) throws EntityNotFoundException {
        orderService.updateOrderStatus(orderMapper.makeOrderFromDTO(orderDTO), newStatus);

        }

}