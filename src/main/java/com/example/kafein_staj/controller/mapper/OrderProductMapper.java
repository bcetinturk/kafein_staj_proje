package com.example.kafein_staj.controller.mapper;


import com.example.kafein_staj.datatransferobject.OrderProductDTO;
import com.example.kafein_staj.entity.OrderProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface OrderProductMapper {
    @Mappings({
            @Mapping(target = "productName", source = "product.productName"),
            @Mapping(target = "productId", source = "product.id")
    })
    OrderProductDTO toDTO(OrderProduct orderProduct);

    @Mappings({
            @Mapping(target = "product.productName", source = "productName"),
            @Mapping(target = "product.id", source = "productId")
    })
    OrderProduct toEntity(OrderProductDTO orderProductDto);
}
