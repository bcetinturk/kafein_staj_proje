package com.example.kafein_staj.entity;

import javax.persistence.Column;
import java.io.Serializable;

public class OrderProductId implements Serializable {
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "order_id")
    private Long orderId;

    public OrderProductId() {}

    public OrderProductId(Long orderId, Long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
