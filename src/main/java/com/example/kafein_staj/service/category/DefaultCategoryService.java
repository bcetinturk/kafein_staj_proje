package com.example.kafein_staj.service.category;

import com.example.kafein_staj.entity.Category;
import com.example.kafein_staj.entity.Product;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.UsedCategoryException;
import com.example.kafein_staj.repository.CategoryRepository;
import com.example.kafein_staj.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.kafein_staj.exception.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultCategoryService implements CategoryService{
    ProductService productService;
    CategoryRepository categoryRepository;

    @Autowired
    public DefaultCategoryService(CategoryRepository categoryRepository, ProductService productService) {
        this.categoryRepository = categoryRepository;
        this.productService = productService;
    }

    @Override
    public Category findById(Long category_id)  throws EntityNotFoundException {
       return categoryRepository.findById(category_id).orElseThrow(
               ()-> new EntityNotFoundException("Category with" + category_id + " does not exists"));
    }

    @Override
    public void deleteCategoryById(Long category_id) throws UsedCategoryException, EntityNotFoundException {
        try {
            boolean isExists=false;
            List<Product> productList;
            productList=productService.findAllByCategoryId(category_id);
            System.out.println("Products: " + productList);
            for(Product product:productList){
                if(product.getCategory().getCategoryId().equals(category_id)){
                    isExists=true;
                    break;
                }

            }
            if(!isExists){
                categoryRepository.deleteById(category_id);
            } else throw new UsedCategoryException("category with " + category_id + " is using");


        } catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("Category with "+category_id+" has already been deleted");
        } catch (EntityNotFoundException e) {
            categoryRepository.deleteById(category_id);
        }
    }

    @Override
    public Category addNewCategory(Category newCategory) throws EntityAlreadyExists {
        try {
            newCategory = categoryRepository.save(newCategory);
            return newCategory;
        }catch (DataIntegrityViolationException exception){
            throw new EntityAlreadyExists("Same category already exits");
        }
    }

    @Override
    public void updateCategory(Category updatedCategory, Long id) throws EntityNotFoundException {
        categoryRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException(""));

        updatedCategory.setCategoryId(id);
        categoryRepository.save(updatedCategory);
    }

    @Override
    public List<Category> findAllByParentId(Long parentId) {
        return categoryRepository.findAllByCategoryParentId(parentId);
    }
}
