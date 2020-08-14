package com.example.kafein_staj.controller;

import com.example.kafein_staj.KafeinStajApplication;
import com.example.kafein_staj.entity.Category;
import com.example.kafein_staj.entity.Product;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.exception.UsedCategoryException;
import com.example.kafein_staj.service.category.CategoryService;
import com.example.kafein_staj.service.category.DefaultCategoryService;
import com.example.kafein_staj.service.product.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(controllers = CategoryController.class)
class CategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;
    @MockBean
    private ProductService productService;
    @InjectMocks
    private CategoryController categoryController;

//    @Test
    void shouldGetCategory() throws Exception {
        Long categoryId = 1L;
        Long parentId = 0L;

        Category category = new Category(parentId, categoryId, "Computer");
        when(categoryService.findById(anyLong())).thenReturn(category);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/category/{id}", categoryId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.parentId").value(parentId));
    }

//    @Test
    void shouldThrowNotFoundGetCategory() throws Exception {
        Long categoryId = 1L;
        when(categoryService.findById(anyLong())).thenThrow(EntityNotFoundException.class);
        mockMvc.perform(
                MockMvcRequestBuilders.get("/category/{id}", categoryId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

//    @Test
    void shouldListSubCategories() throws Exception {
        Long categoryId = 1L;
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(categoryId, 2L, "Desktop"));
        categories.add(new Category(categoryId, 3L, "Notebook"));

        when(categoryService.findAllByParentId(anyLong())).thenReturn(categories);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/category/{id}/categories", categoryId)
                    .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].parentId").value(categoryId))
                .andExpect(jsonPath("$[1].parentId").value(categoryId));
    }

//    @Test
    void shouldReturnEmptyListForSubcategories() throws Exception {
        Long categoryId = 1L;
        List<Category> categories = new ArrayList<>();

        when(categoryService.findAllByParentId(anyLong())).thenReturn(categories);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/category/{id}/categories", categoryId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(0)));
    }

//    @Test
    void shouldListProducts() throws Exception {
        Long categoryId = 1L;
        Category category = new Category(0L, categoryId, "Computer");
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Asus Desktop", 6000L, 20, "Best price", category));
        products.add(new Product(2L, "Dell Desktop", 7000L, 10, "Even better price", category));

        when(productService.findAllByCategoryId(categoryId)).thenReturn(products);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/category/{id}/products", categoryId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].categoryId").value(categoryId))
                .andExpect(jsonPath("$[1].categoryId").value(categoryId));
    }

//    @Test
    void shouldReturnErrorResponseForCategoryWithoutProducts() throws Exception {
        Long categoryId = 1L;

        when(productService.findAllByCategoryId(categoryId)).thenThrow(EntityNotFoundException.class);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/category/{id}/products", categoryId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

//    @Test
    void shouldDeleteEmptyCategory() throws Exception {
        Long categoryId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/category/{id}", categoryId))
            .andDo(print())
            .andExpect(status().isOk());
    }

//    @Test
    void shouldNotDeleteNonEmptyCategory() throws Exception {
        Long categoryId = 1L;

        doThrow(new UsedCategoryException("")).when(categoryService).deleteCategoryById(categoryId);

        mockMvc.perform(MockMvcRequestBuilders.delete("/category/{id}", categoryId))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

//    @Test
    void shouldInformAboutAlreadyDeletedCategory() throws Exception {
        Long categoryId = 1L;

        doThrow(new EntityNotFoundException("")).when(categoryService).deleteCategoryById(categoryId);

        mockMvc.perform(MockMvcRequestBuilders.delete("/category/{id}", categoryId))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

//    @Test
    void shouldUpdateCategory() throws Exception {
        Long categoryId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.patch("/category/{id}", categoryId)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

//    @Test
    void shouldAddNewCategory() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/category/new")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}