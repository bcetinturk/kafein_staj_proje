package com.example.kafein_staj.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(
        name = "User",
        uniqueConstraints = @UniqueConstraint(name = "user_id", columnNames = {"userId"})

)
public class Order {
    @Id
    @GeneratedValue
    private Long order_id;

    @Column(nullable = false)
    @NotNull(message = "order number can not be null!")
    private Long order_no;

    @Column(nullable = false)
    @NotNull(message = "total price can not be null!")
    private Long order_total_price;


    @Column(nullable = false)
    @NotNull(message = "destination")
    private String order_destination;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany
    private List<Product> products;

    public Order(Long order_id, Long order_no, Long order_total_price, String order_destination, User user, List<Product> products) {
        this.order_id = order_id;
        this.order_no = order_no;
        this.order_total_price = order_total_price;
        this.order_destination = order_destination;
        this.user = user;
        this.products = products;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getOrder_no() {
        return order_no;
    }

    public void setOrder_no(Long order_no) {
        this.order_no = order_no;
    }

    public Long getOrder_total_price() {
        return order_total_price;
    }

    public void setOrder_total_price(Long order_total_price) {
        this.order_total_price = order_total_price;
    }

    public String getOrder_destination() {
        return order_destination;
    }

    public void setOrder_destination(String order_destination) {
        this.order_destination = order_destination;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}