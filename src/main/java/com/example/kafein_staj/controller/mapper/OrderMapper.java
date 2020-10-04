package com.example.kafein_staj.controller.mapper;

import com.example.kafein_staj.datatransferobject.OrderDTO;
import com.example.kafein_staj.datatransferobject.ProductDTO;
import com.example.kafein_staj.entity.Order;
import com.example.kafein_staj.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(uses = {OrderProductMapper.class})
public interface OrderMapper {
    OrderDTO makeDTOFromOrder(Order order); // from Entity to DTO

    Order makeOrderFromDTO(OrderDTO orderDTO); // from DTO to Entity

    List<OrderDTO> toListDTO(List<Order> orders);
}
