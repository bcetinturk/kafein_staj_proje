package com.example.kafein_staj.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long product_id;

    @Column(nullable = false)
    @NotNull(message = "product name can not be null!")
    private String productName;

    @Column(nullable = false)
    @NotNull(message = "price can not be null!")
    private long price;

    @Column(nullable = false)
    @NotNull(message = "can not be null!")
    private int quantity;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orders =  new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<BasketProduct> baskets = new ArrayList<>();


    public Product(Long id, String procudt_name, long product_price, int product_quantity, String description, Category category) {
        this.product_id = id;
        this.productName = procudt_name;
        this.price = product_price;
        this.quantity = product_quantity;
        this.description = description;
        this.category = category;
    }

    public Long getId() {
        return product_id;
    }

    public void setId(Long product_id) {
        this.product_id = product_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String procudt_name) {
        this.productName = procudt_name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long product_price) {
        this.price = product_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int product_quantity) {
        this.quantity = product_quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<OrderProduct> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderProduct> orders) {
        this.orders = orders;
    }
}
