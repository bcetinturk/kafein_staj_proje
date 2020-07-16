package com.example.kafein_staj.repository;

import com.example.kafein_staj.entity.Category;
import com.example.kafein_staj.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List <Product> getAllByCategory(Category category);
}
