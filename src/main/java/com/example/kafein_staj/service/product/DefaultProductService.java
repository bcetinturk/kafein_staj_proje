package com.example.kafein_staj.service.product;

import com.example.kafein_staj.entity.Product;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.exception.NoQuantityException;
import com.example.kafein_staj.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DefaultProductService implements ProductService {
    ProductRepository productRepository;
    @Autowired
    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Long product_id)  throws EntityNotFoundException{
       return productRepository.findById(product_id).orElseThrow(
                () -> new EntityNotFoundException("Product with id " + product_id + " does not exist"));
    }

    @Override
    public Product addNewProduct(Product newProduct) throws EntityAlreadyExists{
        Product product;
        try {
            product=productRepository.save(newProduct);

       }catch (DataIntegrityViolationException exception){
                throw new EntityAlreadyExists("Same product already exits");
       }
        return product;
    }

    @Override
    public void deleteById(Long product_id) throws EntityNotFoundException {
        try {
            productRepository.deleteById(product_id);

        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("Order with "+product_id+" has already been deleted");
        }

    }

    @Override
    public int findQuantityById(Long product_id) throws NoQuantityException ,EntityNotFoundException {
        Optional<Product> product;
        product= productRepository.findById(product_id);
        if(product.isPresent()){
        int quantity=product.get().getQuantity();
        if(quantity==0){
            throw new NoQuantityException("Product with "+product.get().getId() + " sold out");
        }else{return quantity;}
        }else{
            throw new EntityNotFoundException("Product does not exits");
        }
    }

    @Override
    public List<Product> findAllByCategoryId(Long category_id) throws EntityNotFoundException {
        List<Product> productList;
       productList= productRepository.getAllByCategory_CategoryId(category_id);
       if(productList.isEmpty()){
           throw new EntityNotFoundException("Product not found");
       }else{
           return productList;
       }
    }
}
