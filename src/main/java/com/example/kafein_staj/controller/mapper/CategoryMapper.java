package com.example.kafein_staj.controller.mapper;

import com.example.kafein_staj.datatransferobject.CategoryDTO;
import com.example.kafein_staj.datatransferobject.OrderDTO;
import com.example.kafein_staj.entity.Category;
import com.example.kafein_staj.entity.Order;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    CategoryDTO makeDTOFromCategory(Category category); // from Entity to DTO
    Category makeCategoryFromDTO(CategoryDTO categoryDTO); // from DTO to Entity

}
