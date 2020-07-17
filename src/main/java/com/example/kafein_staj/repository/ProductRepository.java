package com.example.kafein_staj.repository;

import com.example.kafein_staj.entity.Category;
import com.example.kafein_staj.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List <Product> getAllByCategoryId(Long category_id);
    Optional<Product> findQuantityById(Long product_id);
    Optional<Product> deleteByProductId(Long product_id, Boolean deleted);


}
