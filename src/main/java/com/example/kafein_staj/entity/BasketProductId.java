package com.example.kafein_staj.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BasketProductId implements Serializable {
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "basket_id")
    private Long basketId;

    public BasketProductId() {
    }

    public BasketProductId(Long productId, Long basketId) {
        this.productId = productId;
        this.basketId = basketId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
    }
}
