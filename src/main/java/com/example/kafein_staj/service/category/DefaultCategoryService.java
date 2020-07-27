package com.example.kafein_staj.service.category;

import com.example.kafein_staj.entity.Category;
import com.example.kafein_staj.entity.Product;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class DefaultCategoryService implements CategoryService{

    CategoryRepository categoryRepository;
    @Autowired

    public DefaultCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(Long category_id)  throws EntityNotFoundException {
       return categoryRepository.findById(category_id).orElseThrow(
               ()-> new EntityNotFoundException("Category with" + category_id + " does not exists"));
    }

    @Override
    public void deleteCategoryById(Long category_id) {
        try {
            categoryRepository.deleteById(category_id);

        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("Order with "+category_id+" has already been deleted");
        }
    }

    @Override
    public void addNewCategory(Category newCategory) throws EntityAlreadyExists {
        try {
            categoryRepository.save(newCategory);
        }catch (DataIntegrityViolationException exception){
            throw new EntityAlreadyExists("Same category already exits");
        }

    }
}
