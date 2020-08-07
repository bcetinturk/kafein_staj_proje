package com.example.kafein_staj.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private Long orderId;
    private UUID orderNo;
    private Long totalPrice;
    private String status;
    private String destination;

    private List<OrderProductDTO> products = new ArrayList<>();

    public  OrderDTO(){}

    public OrderDTO(Long orderId, UUID orderNo, Long totalPrice, String status, String destination) {
        this.orderId = orderId;
        this.orderNo = orderNo;
        this.totalPrice = totalPrice;
        this.status = status;
        this.destination = destination;
    }

    public Long getOrderId() {
        return orderId;
    }

    public UUID getOrderNo() { return orderNo; }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public String getDestination() {
        return destination;
    }

    public List<OrderProductDTO> getProducts() {
        return products;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setOrderNo(UUID orderNo) {
        this.orderNo = orderNo;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setProducts(List<OrderProductDTO> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "order_id=" + orderId +
                ", order_no=" + orderNo +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", destination='" + destination + '\'' +
                ", products=" + products +
                '}';
    }
}
