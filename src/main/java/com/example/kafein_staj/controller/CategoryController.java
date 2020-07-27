package com.example.kafein_staj.controller;

import com.example.kafein_staj.controller.mapper.CategoryMapper;
import com.example.kafein_staj.datatransferobject.CategoryDTO;
import com.example.kafein_staj.datatransferobject.ProductDTO;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.mapstruct.factory.Mappers;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class CategoryController {
    CategoryService categoryService;

    @Autowired
    public  CategoryController(CategoryService categoryService) {
        this.categoryService =categoryService;
    }
    private CategoryMapper categoryMapper=  Mappers.getMapper(CategoryMapper.class);

    @GetMapping("/category/{id}")
    CategoryDTO getCategory(@PathVariable Long id) {
        return  categoryMapper.makeDTOFromCategory(categoryService.findById(id));

    }
    @DeleteMapping("/category/{id}")
    void deleteCategory(@PathVariable Long id){
      categoryService.deleteCategoryById(id);
    }

    @PostMapping("/category/new")
    void addNewCategory(@Valid @RequestBody CategoryDTO categoryDTO) throws EntityAlreadyExists {
        categoryService.addNewCategory(categoryMapper.makeCategoryFromDTO(categoryDTO));
    }

    @PatchMapping("/category/{id}")
    void updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable Long id){
        try {
            categoryService.updateCategory(categoryMapper.makeCategoryFromDTO(categoryDTO), id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category with id " + id + " does not exist");
        }
    }
}
