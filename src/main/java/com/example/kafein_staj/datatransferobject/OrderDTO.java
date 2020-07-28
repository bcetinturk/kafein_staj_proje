package com.example.kafein_staj.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private Long order_id;
    private UUID order_no;
    private Long totalPrice;
    private String status;
    private String destination;

    private List<OrderProductDTO> products = new ArrayList<>();

    public  OrderDTO(){}

    public OrderDTO(Long order_id, UUID order_no, Long totalPrice, String status, String destination) {
        this.order_id = order_id;
        this.order_no = order_no;
        this.totalPrice = totalPrice;
        this.status = status;
        this.destination = destination;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public UUID getOrder_no() { return order_no; }

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

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public void setOrder_no(UUID order_no) {
        this.order_no = order_no;
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
                "order_id=" + order_id +
                ", order_no=" + order_no +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", destination='" + destination + '\'' +
                ", products=" + products +
                '}';
    }
}
