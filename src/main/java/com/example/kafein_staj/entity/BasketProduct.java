package com.example.kafein_staj.entity;

import javax.persistence.*;

@Entity
public class BasketProduct {
    @EmbeddedId
    private BasketProductId id;

    @ManyToOne
    @MapsId("basketId")
    private Basket basket;

    @ManyToOne
    @MapsId("productId")
    private Product product;

    @Column(name = "amount")
    private int amount;

    public BasketProduct() {
    }

    public BasketProduct(Basket basket, Product product, int amount) {
        this.basket = basket;
        this.product = product;
        this.amount = amount;
        this.id = new BasketProductId(basket.getBasketId(), product.getId());
    }

    public BasketProductId getId() {
        return id;
    }

    public void setId(BasketProductId id) {
        this.id = id;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
