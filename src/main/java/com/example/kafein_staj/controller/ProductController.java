package com.example.kafein_staj.controller;

import com.example.kafein_staj.controller.mapper.ProductMapper;
import com.example.kafein_staj.datatransferobject.ProductDTO;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.exception.NoQuantityException;
import com.example.kafein_staj.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.mapstruct.factory.Mappers;

import javax.validation.Valid;

@RestController
public class ProductController {
    ProductService productService;
    private ProductMapper productMapper= Mappers.getMapper(ProductMapper.class);

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/product/{id}")
    ProductDTO getProduct(@PathVariable Long id) throws EntityNotFoundException {
        return productMapper.makeDTOFromProduct(productService.findById(id));
            }

    @PostMapping("/product/new")
    void addNewProduct(@Valid @RequestBody ProductDTO productDTO) throws EntityAlreadyExists {
        productService.addNewProduct(productMapper.makeProductFromDTO(productDTO));
    }

    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable Long id) throws EntityNotFoundException {
       productService.deleteById(id);

    }

    void getProductQuantity(ProductDTO productDTO) throws NoQuantityException,EntityNotFoundException {
        productService.findQuantityById(productDTO.getProduct_id());
    }
}
