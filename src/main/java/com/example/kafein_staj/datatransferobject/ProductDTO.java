package com.example.kafein_staj.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO   {
    private Long productId;
    private String productName;
    private long price;
    private int quantity;
    private String description;
    private Long categoryId;

    public ProductDTO(){}

    public ProductDTO(Long prodcut_id, String productName, long price, int quantity, String description, Long categoryId) {
        this.productId = prodcut_id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.categoryId = categoryId;
    }

    @JsonProperty

    public Long getProductId() { return productId; }

    public String getProductName() { return productName; }

    public long getPrice() { return price; }

    public int getQuantity() { return quantity; }

    public String getDescription() {
        return description;
    }

    public Long getCategoryId() { return categoryId; }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategoryId(Long categoryId) {this.categoryId = categoryId; }

}
