package com.example.kafein_staj.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class BasketProductDTO {
    private Long basket_id;
    private Long product_id;
    private Integer amount;

    public BasketProductDTO() {
    }

    public BasketProductDTO(Long basket_id, Long product_id, Integer amount) {
        this.basket_id = basket_id;
        this.product_id = product_id;
        this.amount = amount;
    }

    public Long getBasket_id() {
        return basket_id;
    }

    public void setBasket_id(Long basket_id) {
        this.basket_id = basket_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BasketProductDTO{" +
                "basket_id=" + basket_id +
                ", product_id=" + product_id +
                ", amount=" + amount +
                '}';
    }
}
