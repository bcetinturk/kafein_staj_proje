package com.example.kafein_staj.controller.mapper;

import com.example.kafein_staj.datatransferobject.OrderDTO;
import com.example.kafein_staj.datatransferobject.ProductDTO;
import com.example.kafein_staj.entity.Order;
import com.example.kafein_staj.entity.Product;

@Mapper
public interface OrderMapper {
    OrderDTO makeDTOFromOrder(Order order); // from Entity to DTO
    Order makeOrderFromDTO(OrderDTO orderDTO); // from DTO to Entity
}
