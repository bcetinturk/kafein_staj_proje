package com.example.kafein_staj.controller.mapper;

import com.example.kafein_staj.datatransferobject.CategoryDTO;
import com.example.kafein_staj.datatransferobject.OrderDTO;
import com.example.kafein_staj.entity.Category;
import com.example.kafein_staj.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Mapping(target = "parentId", source = "categoryParentId")
    CategoryDTO makeDTOFromCategory(Category category); // from Entity to DTO

    @Mapping(target = "categoryParentId", source = "parentId")
    Category makeCategoryFromDTO(CategoryDTO categoryDTO); // from DTO to Entity

    List<CategoryDTO> dtosFromCategories(List<Category> categories);

    List<Category> categoriesFromDtos(List<CategoryDTO> categoryDTOS);
}
