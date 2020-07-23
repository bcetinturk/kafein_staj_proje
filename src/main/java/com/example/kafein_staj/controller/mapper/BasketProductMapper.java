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
            @Mapping(target = "basket_id", source = "basket.id"),
            @Mapping(target = "product_id", source = "product.id"),
            @Mapping(target = "amount", source = "amount")
    })
    BasketProductDTO basketProductToBasketProductDTO(BasketProduct basketProduct);

    @Mappings({
            @Mapping(target = "basket.id", source = "basket_id"),
            @Mapping(target = "product.id", source = "product_id"),
            @Mapping(target = "amount", source = "amount")
    })
    BasketProduct basketProductDTOToBasketProduct(BasketProductDTO basketProductDto);
}
