package com.example.kafein_staj.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class OrderProductDTO {
    Integer amount;
    String productName;
    Long productId;

    public OrderProductDTO() {
    }

    public OrderProductDTO(Integer amount, String productName) {
        this.amount = amount;
        this.productName = productName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "OrderProductDTO{" +
                "amount=" + amount +
                ", productName='" + productName + '\'' +
                ", productId=" + productId +
                '}';
    }
}
