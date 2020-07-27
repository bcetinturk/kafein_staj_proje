package com.example.kafein_staj.service.category;

import com.example.kafein_staj.entity.Category;
import com.example.kafein_staj.exception.EntityAlreadyExists;

public interface CategoryService {
    Category findById(Long category_id);
    void deleteCategoryById(Long category_id);
    void addNewCategory(Category newCategory) throws EntityAlreadyExists;
}
