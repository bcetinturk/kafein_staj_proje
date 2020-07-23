package com.example.kafein_staj.controller;

import com.example.kafein_staj.controller.mapper.CategoryMapper;
import com.example.kafein_staj.datatransferobject.CategoryDTO;
import com.example.kafein_staj.datatransferobject.ProductDTO;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.mapstruct.factory.Mappers;

import javax.validation.Valid;

public class CategoryController {
    CategoryService categoryService;

    @Autowired
    public  CategoryController(CategoryService categoryService) {
        this.categoryService =categoryService;
    }
    private CategoryMapper categoryMapper=  Mappers.getMapper(CategoryMapper.class);

    @GetMapping("/category/{id}")
    CategoryDTO getCategory(@PathVariable Long category_id) {
        return  categoryMapper.makeDTOFromCategory(categoryService.findById(category_id));

    }
    @DeleteMapping("/category/{id}")
    void deleteCategory(@PathVariable Long id){
      categoryService.deleteCategoryById(id);
    }
    @PostMapping("/category/newProduct")
    void addNewCategory(@Valid @RequestBody CategoryDTO categoryDTO) throws EntityAlreadyExists {
        categoryService.addNewCategory(categoryMapper.makeCategoryFromDTO(categoryDTO));    }
}
