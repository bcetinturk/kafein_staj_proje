package com.example.kafein_staj.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_product")
public class OrderProduct {
//    @EmbeddedId
//    private OrderProductId id;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "amount")
    private int amount;

    public OrderProduct() {
    }

    public OrderProduct(Order order, Product product, int amount) {
        this.order = order;
        this.product = product;
        //this.id = new OrderProductId(order.getOrderId(), product.getId());
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", order=" + order.getOrderId() +
                ", product=" + product.getId() +
                ", amount=" + amount +
                '}';
    }
}
