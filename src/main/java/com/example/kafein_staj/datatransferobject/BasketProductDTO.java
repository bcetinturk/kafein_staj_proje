package com.example.kafein_staj.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class BasketProductDTO {
    private Long basketId;
    private Long productId;
    private Integer amount;

    public BasketProductDTO() {
    }

    public BasketProductDTO(Long basketId, Long productId, Integer amount) {
        this.basketId = basketId;
        this.productId = productId;
        this.amount = amount;
    }

    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
                "basket_id=" + basketId +
                ", product_id=" + productId +
                ", amount=" + amount +
                '}';
    }
}
