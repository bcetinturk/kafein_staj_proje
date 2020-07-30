package com.example.kafein_staj.service.category;

import com.example.kafein_staj.entity.Category;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;

import java.util.List;
import com.example.kafein_staj.exception.UsedCategoryException;

public interface CategoryService {
    Category findById(Long category_id) throws EntityNotFoundException;
    void deleteCategoryById(Long category_id) throws UsedCategoryException, EntityNotFoundException;
    Category addNewCategory(Category newCategory) throws EntityAlreadyExists;
    void updateCategory(Category updatedCategory, Long id) throws EntityNotFoundException;
    List<Category> findAllByParentId(Long parentId);
}
