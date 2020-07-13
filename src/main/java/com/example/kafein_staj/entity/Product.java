package com.example.kafein_staj.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name="Product",
        uniqueConstraints = @UniqueConstraint(name = "product_id", columnNames = {"productId"})

)
public class Product {
    @Id
    @GeneratedValue
    private Long product_id;

    @Column(nullable = false)
    @NotNull(message = "product name can not be null!")
    private String procudt_name;

    @Column(nullable = false)
    @NotNull(message = "price can not be null!")
    private long product_price;

    @Column(nullable = false)
    @NotNull(message = "can not be null!")
    private int product_quantity;

    @Column(nullable = false)
    @NotNull(message = "can not be null!")
    private String product_destination;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orders =  new ArrayList<>();


    public Product(Long product_id, String procudt_name, long product_price, int product_quantity, String product_destination, Category category) {
        this.product_id = product_id;
        this.procudt_name = procudt_name;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.product_destination = product_destination;
        this.category = category;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProcudt_name() {
        return procudt_name;
    }

    public void setProcudt_name(String procudt_name) {
        this.procudt_name = procudt_name;
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

    public String getProduct_destination() {
        return product_destination;
    }

    public void setProduct_destination(String product_destination) {
        this.product_destination = product_destination;
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
