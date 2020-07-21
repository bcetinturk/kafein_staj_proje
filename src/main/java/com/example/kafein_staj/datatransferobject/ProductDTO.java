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

    private Category category;
    private List<OrderProduct> orders =  new ArrayList<>();
    private List<BasketProduct> baskets = new ArrayList<>();

    public ProductDTO(){}

    public ProductDTO(Long prodcut_id, String productName, long price, int quantity, String description) {
        this.product_id = prodcut_id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    @JsonProperty

    public Long getProduct_id() { return product_id; }

    public String getProductName() { return productName; }

    public long getPrice() { return price; }

    public int getQuantity() { return quantity; }

    public Category getCategory() { return category; }

    public List<OrderProduct> getOrders() { return orders; }

    public List<BasketProduct> getBaskets() { return baskets; }

    public String getDescription() {
        return description;
    }

    public static class ProductDTOBuilder{
        private Long product_id;
        private String productName;
        private int quantity;
        private String description;
        private long price;
        private Category category;
        private List<OrderProduct> orders =  new ArrayList<>();
        private List<BasketProduct> baskets = new ArrayList<>();

        public ProductDTOBuilder(Long product_id, String productName, int quantity, String description, long price) {
            this.product_id = product_id;
            this.productName = productName;
            this.quantity = quantity;
            this.description = description;
            this.price = price;
        }

        public ProductDTOBuilder setProduct_id(Long product_id) {
            this.product_id = product_id;
            return this;
        }

        public ProductDTOBuilder setProductName(String productName) {
            this.productName = productName;
            return  this;
        }

        public ProductDTOBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductDTOBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductDTOBuilder setPrice(long price) {
            this.price = price;
            return this;
        }

        public ProductDTOBuilder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public ProductDTOBuilder setOrders(List<OrderProduct> orders) {
            this.orders = orders;
            return this;
        }

        public ProductDTOBuilder setBaskets(List<BasketProduct> baskets) {
            this.baskets = baskets;
            return this;
        }
    }
}
