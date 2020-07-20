package com.example.kafein_staj.service.basket;

import com.example.kafein_staj.entity.Basket;
import com.example.kafein_staj.entity.BasketProduct;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.repository.BasketProductRepository;
import com.example.kafein_staj.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Basket findByUser_Id(Long id) throws EntityNotFoundException {
        return basketRepository.findByUser_Id(id).orElseThrow(
                () -> new EntityNotFoundException("User does not exist or does not have a basket"));
    }

    @Override
    public List<BasketProduct> getAllProductsById(Long id) throws EntityNotFoundException {
        return basketProductRepository.findAllByBasket_BasketId(id).orElseThrow(
                () -> new EntityNotFoundException("Basket is empty"));
    }
}
