package com.example.kafein_staj.controller.mapper;

import com.example.kafein_staj.datatransferobject.ProductDTO;
import com.example.kafein_staj.entity.Product;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
        @Mappings({
                @Mapping(target = "product_id", source = "id"),
                @Mapping(target = "categoryId", source = "category.categoryId")
        })
        ProductDTO makeDTOFromProduct(Product product); // from Entity to DTO


        @Mappings({
                @Mapping(target = "id", source = "product_id"),
                @Mapping(target = "category.categoryId", source = "categoryId")
        })
        Product makeProductFromDTO(ProductDTO productDTO); // from DTO to Entity
}
