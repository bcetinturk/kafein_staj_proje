package com.example.kafein_staj.service.basket;

import com.example.kafein_staj.entity.Basket;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultBasketService implements BasketService {
    private BasketRepository basketRepository;

    @Autowired
    public DefaultBasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
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
}
