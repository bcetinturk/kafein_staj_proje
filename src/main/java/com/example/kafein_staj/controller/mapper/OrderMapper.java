package com.example.kafein_staj.controller.mapper;

import com.example.kafein_staj.datatransferobject.OrderDTO;
import com.example.kafein_staj.datatransferobject.ProductDTO;
import com.example.kafein_staj.entity.Order;
import com.example.kafein_staj.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface OrderMapper {
    @Mappings({
            @Mapping(target = "order_id", source = "orderId"),
            @Mapping(target = "order_no", source = "orderNo")
    })
    OrderDTO makeDTOFromOrder(Order order); // from Entity to DTO

    @Mappings({
            @Mapping(target = "orderId", source = "order_id"),
<<<<<<< HEAD
            @Mapping(target = "orderNo", source = "order_no")
=======
            @Mapping(target = "orderNo", source = "order_no"),

>>>>>>> develop
    })
    Order makeOrderFromDTO(OrderDTO orderDTO); // from DTO to Entity
}
