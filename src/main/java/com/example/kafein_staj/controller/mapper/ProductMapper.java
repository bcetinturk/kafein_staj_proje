package com.example.kafein_staj.controller.mapper;

import com.example.kafein_staj.datatransferobject.ProductDTO;
import com.example.kafein_staj.entity.Product;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
        ProductDTO makeDTOFromProduct(Product product); // from Entity to DTO
        Product makeProductFromDTO(ProductDTO productDTO); // from DTO to Entity
}
