package com.example.kafein_staj.repository;

import com.example.kafein_staj.datatransferobject.BasketDTO;
import com.example.kafein_staj.entity.BasketProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BasketProductRepository extends CrudRepository<BasketProduct, Long> {
    Optional<List<BasketProduct>> findAllByBasket_Id(Long basket_idd);

    // Sepetteki bütün ürünleri fiyat ve adediyle döndürür
    @Query("select new com.example.kafein_staj.datatransferobject.BasketDTO(p.id, p.productName, p.price, bp.amount) from Basket b, BasketProduct bp, Product p where b.id=bp.basket and bp.product=p.id and b.id=:basketId")
    List<BasketDTO> getBasketDetails(@Param("basketId") Long basketId);

    void deleteByBasket_IdAndProduct_Id(Long basket_id, Long product_id);

    Optional<BasketProduct> findByBasket_IdAndProduct_Id(Long basket_id, Long product_id);
}
