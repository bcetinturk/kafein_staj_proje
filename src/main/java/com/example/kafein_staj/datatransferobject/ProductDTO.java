package com.example.kafein_staj.datatransferobject;

import com.example.kafein_staj.entity.OrderProduct;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO   {
    private Long product_id;
    private String productName;
    private long price;
    private int quantity;
    private String description;
    private Long categoryId;

    public ProductDTO(){}

    public ProductDTO(Long prodcut_id, String productName, long price, int quantity, String description, Long categoryId) {
        this.product_id = prodcut_id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.categoryId = categoryId;
    }

    @JsonProperty

    public Long getProduct_id() { return product_id; }

    public String getProductName() { return productName; }

    public long getPrice() { return price; }

    public int getQuantity() { return quantity; }

    public String getDescription() {
        return description;
    }

    public Long getCategoryId() { return categoryId; }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
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
