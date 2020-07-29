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
    OrderDTO getOrder(@PathVariable Long order_id) throws EntityNotFoundException {
        return orderMapper.makeDTOFromOrder(orderService.findById(order_id));
    }

    @PostMapping("/user/{userId}/order/new")
    OrderDTO placeNewOrder(@PathVariable Long userId) throws EntityNotFoundException {
        return orderMapper.makeDTOFromOrder(orderService.newOrder(userId));
    }

    @DeleteMapping("/order/{order_id}")
    void deleteOrder(@PathVariable Long order_id) throws EntityNotFoundException {
        orderService.deleteById(order_id);
    }

    @PatchMapping("/order/{order_id}/status")
    OrderDTO updateOrder(@PathVariable Long order_id, @RequestBody OrderDTO newStatus) throws EntityNotFoundException, IllegalOperationException {
        return orderMapper.makeDTOFromOrder(orderService.updateOrderStatus(order_id, newStatus));
    }

//    @PutMapping("/order/{orderDTO}")
//    void cancelledOrder(@PathVariable OrderDTO orderDTO) throws EntityNotFoundException{
//        orderService.cancelledOrder(orderMapper.makeOrderFromDTO(orderDTO));
//    }
}
