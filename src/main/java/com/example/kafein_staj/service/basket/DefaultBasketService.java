package com.example.kafein_staj.service.basket;

import com.example.kafein_staj.datatransferobject.BasketDTO;
import com.example.kafein_staj.entity.Basket;
import com.example.kafein_staj.entity.BasketProduct;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.repository.BasketProductRepository;
import com.example.kafein_staj.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DefaultBasketService implements BasketService {
    private BasketRepository basketRepository;
    private BasketProductRepository basketProductRepository;

    @Autowired
    public DefaultBasketService(BasketRepository basketRepository, BasketProductRepository basketProductRepository) {
        this.basketRepository = basketRepository;
        this.basketProductRepository = basketProductRepository;
    }

    @Override
    public Basket findById(Long id) throws EntityNotFoundException {
        return basketRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No basket was found with id " + id));
    }

    @Override
    public List<BasketDTO> findByUser_Id(Long id) throws EntityNotFoundException {
        Basket basket = basketRepository.findByUser_Id(id).orElseThrow(
                () -> new EntityNotFoundException("User does not exist or does not have a basket"));

        return basketProductRepository.getBasketDetails(basket.getId());
    }

    @Override
    public List<BasketProduct> getAllProductsById(Long id) throws EntityNotFoundException {
        return basketProductRepository.findAllByBasket_Id(id).orElseThrow(
                () -> new EntityNotFoundException("Basket is empty"));
    }

    @Override
    public void addItemToBasket(BasketProduct basketProduct) throws EntityAlreadyExists {
        try {
             basketProductRepository.save(basketProduct);
        } catch (DataIntegrityViolationException e) {
            throw new EntityAlreadyExists("Item already added to basket");
        }
    }

    @Override
    @Transactional
    public void deleteItemFromBasket(BasketProduct basketProduct) throws EntityNotFoundException {
        try {
            basketProductRepository.deleteByBasket_IdAndProduct_Id(
                    basketProduct.getBasket().getId(),
                    basketProduct.getProduct().getId());
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Item already deleted from basket");
        }
    }
}
