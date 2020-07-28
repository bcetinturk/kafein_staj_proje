package com.example.kafein_staj.controller.mapper;


import com.example.kafein_staj.datatransferobject.OrderProductDTO;
import com.example.kafein_staj.entity.OrderProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface OrderProductMapper {
    @Mappings({
            @Mapping(target = "product_name", source = "product.productName"),
            @Mapping(target = "product_id", source = "product.id")
    })
    OrderProductDTO toDTO(OrderProduct orderProduct);

    @Mappings({
            @Mapping(target = "product.productName", source = "product_name"),
            @Mapping(target = "product.id", source = "product_id")
    })
    OrderProduct toEntity(OrderProductDTO orderProductDto);
}
