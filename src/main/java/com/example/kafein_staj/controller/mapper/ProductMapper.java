package com.example.kafein_staj.controller.mapper;

import com.example.kafein_staj.datatransferobject.ProductDTO;
import com.example.kafein_staj.entity.Product;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
        @Mappings({
                @Mapping(target = "productId", source = "id"),
                @Mapping(target = "categoryId", source = "category.categoryId")
        })
        ProductDTO makeDTOFromProduct(Product product); // from Entity to DTO


        @Mappings({
                @Mapping(target = "id", source = "productId"),
                @Mapping(target = "category.categoryId", source = "categoryId")
        })
        Product makeProductFromDTO(ProductDTO productDTO); // from DTO to Entity

        List<ProductDTO> dtosFromProducts(List<Product> products);
        List<Product> productsFromdtos(List<ProductDTO> productDTOs);
}
