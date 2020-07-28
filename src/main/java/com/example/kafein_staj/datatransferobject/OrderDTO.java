package com.example.kafein_staj.datatransferobject;

import com.example.kafein_staj.entity.OrderProduct;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    @NotNull(message = "Order id can not be null!")
    private Long order_id;
    @NotNull(message = "order number can not be null!")
    private Long order_no;
    @NotNull(message = "total price can not be null!")
    private Long totalPrice;
    @NotNull(message = "status can not be null!")
    private String status;

    @NotNull(message = "destination can not be null!")
    private String destination;
    private Long userDTO_id;
    private List<OrderProductDTO> products = new ArrayList<>();

    public  OrderDTO(){}

    public OrderDTO(Long order_id, Long order_no, Long totalPrice, String status, String destination, Long userDTO_id) {
        this.order_id = order_id;
        this.order_no = order_no;
        this.totalPrice = totalPrice;
        this.status = status;
        this.destination = destination;
        this.userDTO_id = userDTO_id;
    }
    @JsonProperty

    public Long getOrder_id() {
        return order_id;
    }

    public Long getOrder_no() { return order_no; }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public String getDestination() {
        return destination;
    }

    public Long getUserDTO_id() {
        return userDTO_id;
    }

    public List<OrderProductDTO> getProducts() {
        return products;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public void setOrder_no(Long order_no) {
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

    public void setUserDTO_id(Long userDTO_id) {
        this.userDTO_id = userDTO_id;
    }

    public void setProducts(List<OrderProductDTO> products) {
        this.products = products;
    }
}
