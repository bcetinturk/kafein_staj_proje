package com.example.kafein_staj.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="corder")
public class Order {
    @Id
    @GeneratedValue
    private Long orderId;

    @Column(nullable = false)
    @NotNull(message = "order number can not be null!")
    private UUID orderNo;

    @Column(nullable = false)
    @NotNull(message = "total price can not be null!")
    private Long totalPrice;


    @Column(nullable = false)
    @NotNull(message = "destination can not be null!")
    private String destination;

    @Column(nullable = false)
    @NotNull(message = "status can not be null!")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduct> products = new ArrayList<>();

    public Order(Long orderId, UUID orderNo, Long totalPrice, String destination, String status, User user) {
        this.orderId = orderId;
        this.orderNo = orderNo;
        this.totalPrice = totalPrice;
        this.destination = destination;
        this.status = status;
        this.user = user;
    }

    public Order() {

    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long order_id) {
        this.orderId = order_id;
    }

    public UUID getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(UUID order_no) {
        this.orderNo = order_no;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long order_total_price) {
        this.totalPrice = order_total_price;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String order_destination) {
        this.destination = order_destination;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public List<OrderProduct> getProducts() {
        return products;
    }

    public void setProducts(List<OrderProduct> products) {
        this.products = products;
    }
}