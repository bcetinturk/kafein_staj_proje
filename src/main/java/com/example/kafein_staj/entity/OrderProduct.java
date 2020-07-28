package com.example.kafein_staj.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_product")
public class OrderProduct {
    @EmbeddedId
    private OrderProductId id;

    @ManyToOne
    @MapsId("orderId")
    private Order order;

    @ManyToOne
    @MapsId("productId")
    private Product product;

    @Column(name = "amount")
    private int amount;

    public OrderProduct() {
    }

    public OrderProduct(Order order, Product product, int amount) {
        this.order = order;
        this.product = product;
        this.id = new OrderProductId(order.getOrderId(), product.getId());
        this.amount = amount;
    }

    public OrderProductId getId() {
        return id;
    }

    public void setId(OrderProductId id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
