package com.example.kafein_staj.datatransferobject;

public class BasketDTO {
    private Long productId;
    private String productName;
    private Long price;
    private Integer amount;

    public BasketDTO(Long productId, String productName, Long price, Integer amount) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
