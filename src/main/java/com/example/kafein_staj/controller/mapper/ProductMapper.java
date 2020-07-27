package com.example.kafein_staj.controller.mapper;

import com.example.kafein_staj.datatransferobject.ProductDTO;
import com.example.kafein_staj.entity.Product;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

        @Mapping(target = "product_id ", source = "id")
        ProductDTO makeDTOFromProduct(Product product); // from Entity to DTO

        @Mapping(target = "id", source = "product_id")
        Product makeProductFromDTO(ProductDTO productDTO); // from DTO to Entity
}
