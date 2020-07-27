package com.example.kafein_staj.service.category;

import com.example.kafein_staj.entity.Category;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.exception.UsedCategoryException;

public interface CategoryService {
    Category findById(Long category_id);
    void deleteCategoryById(Long category_id) throws UsedCategoryException;
    void addNewCategory(Category newCategory) throws EntityAlreadyExists;
    void updateCategory(Category updatedCategory, Long id) throws EntityNotFoundException;
}
