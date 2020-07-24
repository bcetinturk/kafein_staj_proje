package com.example.kafein_staj.controller.mapper;

import com.example.kafein_staj.datatransferobject.OrderDTO;
import com.example.kafein_staj.datatransferobject.ProductDTO;
import com.example.kafein_staj.entity.Order;
import com.example.kafein_staj.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class OrderMapper {
    OrderDTO makeDTOFromOrder(Order order){

        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setOrder_id(order.getOrderId());
        orderDTO.setOrder_no(order.getOrderNo());
        orderDTO.setDestination(order.getDestination());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setUserDTO_id(order.getUser().getId());

        return orderDTO;
    }
    Order makeOrderFromDTO(OrderDTO orderDTO){

        Order order=new Order();
        order.setOrderId(orderDTO.getOrder_id());
        order.setOrderNo(orderDTO.getOrder_no());
        order.setStatus(orderDTO.getStatus());
        order.setDestination(orderDTO.getDestination());
        order.setStatus(orderDTO.getStatus());
        order.getUser().setId(orderDTO.getUserDTO_id());

        return order;
    }
}
