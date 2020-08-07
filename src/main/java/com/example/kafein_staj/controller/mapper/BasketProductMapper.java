package com.example.kafein_staj.controller.mapper;

import com.example.kafein_staj.datatransferobject.BasketDTO;
import com.example.kafein_staj.datatransferobject.BasketProductDTO;
import com.example.kafein_staj.entity.BasketProduct;
import com.example.kafein_staj.repository.BasketRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {BasketRepository.class})
public interface BasketProductMapper {
    @Mappings({
            @Mapping(target = "basketId", source = "basket.id"),
            @Mapping(target = "productId", source = "product.id"),
            @Mapping(target = "amount", source = "amount")
    })
    BasketProductDTO basketProductToBasketProductDTO(BasketProduct basketProduct);

    @Mappings({
            @Mapping(target = "basket.id", source = "basketId"),
            @Mapping(target = "product.id", source = "productId"),
            @Mapping(target = "amount", source = "amount")
    })
    BasketProduct basketProductDTOToBasketProduct(BasketProductDTO basketProductDto);
}
