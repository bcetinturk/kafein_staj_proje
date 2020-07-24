package com.example.kafein_staj.controller.mapper;

import com.example.kafein_staj.datatransferobject.ProductDTO;
import com.example.kafein_staj.entity.Product;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class ProductMapper {
        ProductDTO makeDTOFromProduct(Product product){

                ProductDTO productDTO=new ProductDTO();
                productDTO.setProduct_id(product.getId());
                productDTO.setPrice(product.getPrice());
                productDTO.setProductName(product.getProductName());
                productDTO.setCategoryDTO_id(product.getCategory().getCategoryId());
                productDTO.setDescription(product.getDescription());

                return  productDTO;

        }
        Product makeProductFromDTO(ProductDTO productDTO){

                Product product=new Product();
                product.setProductName(productDTO.getProductName());
                product.setId(productDTO.getProduct_id());
                product.setPrice(productDTO.getPrice());
                product.setDescription(productDTO.getDescription());
                product.getCategory().setCategoryId(productDTO.getCategoryDTO_id());
                product.setQuantity(productDTO.getQuantity());

                return product;
        }
}
