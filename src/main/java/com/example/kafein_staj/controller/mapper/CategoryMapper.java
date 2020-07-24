package com.example.kafein_staj.controller.mapper;

import com.example.kafein_staj.datatransferobject.CategoryDTO;
import com.example.kafein_staj.datatransferobject.OrderDTO;
import com.example.kafein_staj.entity.Category;
import com.example.kafein_staj.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class CategoryMapper {
    public CategoryDTO makeDTOFromCategory(Category category){
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setCategory_parent_id(category.getCategoryParentId());
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setTitle(category.getTitle());
        return categoryDTO;
    }
    public Category makeCategoryFromDTO(CategoryDTO categoryDTO){

        Category category=new Category();
        category.setCategoryId(categoryDTO.getCategoryId());
        category.setCategoryParentId(categoryDTO.getCategory_parent_id());
        category.setTitle(categoryDTO.getTitle());
        return category;

    }

}
