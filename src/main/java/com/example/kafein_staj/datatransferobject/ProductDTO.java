package com.example.kafein_staj.datatransferobject;


import com.example.kafein_staj.entity.BasketProduct;
import com.example.kafein_staj.entity.Category;
import com.example.kafein_staj.entity.OrderProduct;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO   {
    @NotNull(message = "Product id can not be null!")
    private Long product_id;

    @NotNull(message = "product name can not be null!")
    private String productName;

    @NotNull(message = "price can not be null!")
    private long price;

    @NotNull(message = "can not be null!")
    private int quantity;

    private String description;

    private CategoryDTO categoryDTO;
    private List<OrderProduct> orders =  new ArrayList<>();
    private List<BasketProduct> baskets = new ArrayList<>();

    public ProductDTO(){}

    public ProductDTO(Long prodcut_id, String productName, long price, int quantity, String description,CategoryDTO categoryDTO) {
        this.product_id = prodcut_id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.categoryDTO=categoryDTO;
    }

    @JsonProperty

    public Long getProduct_id() { return product_id; }

    public String getProductName() { return productName; }

    public long getPrice() { return price; }

    public int getQuantity() { return quantity; }

    public CategoryDTO getCategoryDTO() { return categoryDTO; }

    public List<OrderProduct> getOrders() { return orders; }

    public List<BasketProduct> getBaskets() { return baskets; }

    public String getDescription() {
        return description;
    }

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

    public void setCategory(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public void setOrders(List<OrderProduct> orders) {
        this.orders = orders;
    }

    public void setBaskets(List<BasketProduct> baskets) {
        this.baskets = baskets;
    }
}
