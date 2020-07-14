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
    private String product_name;

    @Column(nullable = false)
    @NotNull(message = "price can not be null!")
    private long product_price;

    @Column(nullable = false)
    @NotNull(message = "can not be null!")
    private int product_quantity;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orders =  new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<BasketProduct> baskets = new ArrayList<>();


    public Product(Long product_id, String procudt_name, long product_price, int product_quantity, String description, Category category) {
        this.product_id = product_id;
        this.product_name = procudt_name;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.description = description;
        this.category = category;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String procudt_name) {
        this.product_name = procudt_name;
    }

    public long getProduct_price() {
        return product_price;
    }

    public void setProduct_price(long product_price) {
        this.product_price = product_price;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
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
