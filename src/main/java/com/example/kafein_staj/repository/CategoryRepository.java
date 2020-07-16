package com.example.kafein_staj.repository;

import com.example.kafein_staj.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
  List<Category> findAllByCategoryParentId(Long category_parent_id);
  Optional<Category> findByTitle(String title);
  }
