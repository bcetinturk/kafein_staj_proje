package com.example.kafein_staj.repository;

import com.example.kafein_staj.entity.Category;
import com.example.kafein_staj.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List <Product> getAllByCategory_CategoryId(Long category_id);
    @Query("select quantity from Product WHERE id = :product_id")
    Optional<Integer> findQuantityById(@Param("product_id") Long product_id);
    void deleteById(Long aLong);
}
