package com.example.kafein_staj.controller;

import com.example.kafein_staj.controller.mapper.CategoryMapper;
import com.example.kafein_staj.controller.mapper.ProductMapper;
import com.example.kafein_staj.datatransferobject.CategoryDTO;
import com.example.kafein_staj.datatransferobject.ProductDTO;
import com.example.kafein_staj.entity.Product;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
/*import com.example.kafein_staj.exception.UsedCategoryException;*/
import com.example.kafein_staj.service.category.CategoryService;
import com.example.kafein_staj.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.mapstruct.factory.Mappers;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryController {
    CategoryService categoryService;
    ProductService productService;

    private CategoryMapper categoryMapper=  Mappers.getMapper(CategoryMapper.class);
    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Autowired
    public  CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService =categoryService;
        this.productService = productService;
    }

    @GetMapping("/category/{id}")
    CategoryDTO getCategory(@PathVariable Long id) {
        return categoryMapper.makeDTOFromCategory(categoryService.findById(id));
    }

    @GetMapping("/category/{id}/categories")
    List<CategoryDTO> getSubcategories(@PathVariable Long id) {
        return categoryMapper.dtosFromCategories(categoryService.findAllByParentId(id));
    }

    @GetMapping("category/{id}/products")
    List<ProductDTO> getProductsByCategory(@PathVariable Long id) throws EntityNotFoundException {
        return productMapper.dtosFromProducts(productService.findAllByCategoryId(id));
    }

    @DeleteMapping("/category/{id}")
    void deleteCategory(@PathVariable Long id) /*throws  UsedCategoryException*/ {
      categoryService.deleteCategoryById(id);
    }

    @PostMapping("/category/new")
    CategoryDTO addNewCategory(@Valid @RequestBody CategoryDTO categoryDTO) throws EntityAlreadyExists {
        return categoryMapper.makeDTOFromCategory(
                categoryService.addNewCategory(categoryMapper.makeCategoryFromDTO(categoryDTO)));
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
