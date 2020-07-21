package com.example.kafein_staj.datatransferobject;

import com.example.kafein_staj.entity.Order;
import com.example.kafein_staj.entity.OrderProduct;
import com.example.kafein_staj.entity.User;
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
    private UserDTO userDTO;
    private List<OrderProduct> products = new ArrayList<>(); // Daha sonra DTO olacak

    public  OrderDTO(){}

    public OrderDTO(Long order_id, Long order_no, Long totalPrice, String status, String destination) {
        this.order_id = order_id;
        this.order_no = order_no;
        this.totalPrice = totalPrice;
        this.status = status;
        this.destination = destination;
    }
    @JsonProperty

    public Long getOrder_id() {
        return order_id;
    }

    public Long getOrderNo() {
        return order_no;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public String getDestination() {
        return destination;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public List<OrderProduct> getProducts() {
        return products;
    }

    public static class OrderDTOBuilder{
        private Long order_id;
        private Long order_no;
        private Long total_price;
        private String status;
        private String destination;
        private UserDTO userDTO;
        private List<OrderProduct> products = new ArrayList<>(); // Daha sonra DTO olacak

        public OrderDTOBuilder(Long order_id, Long order_no, Long total_price, String status, String destination) {
            this.order_id = order_id;
            this.order_no = order_no;
            this.total_price = total_price;
            this.status = status;
            this.destination = destination;
        }

        public OrderDTOBuilder setOrder_id(Long order_id) {
            this.order_id = order_id;
            return this;
        }

        public OrderDTOBuilder setOrder_no(Long order_no) {
            this.order_no = order_no;
            return this;
        }

        public OrderDTOBuilder setTotal_price(Long total_price) {
            this.total_price = total_price;
            return this;
        }

        public OrderDTOBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public OrderDTOBuilder setDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public OrderDTOBuilder setUserDTO(UserDTO userDTO) {
            this.userDTO = userDTO;
            return this;
        }

        public OrderDTOBuilder setProducts(List<OrderProduct> products) {
            this.products = products;
            return this;
        }
        public OrderDTO createOrderDTO(){
            return new OrderDTO(order_id,order_no,total_price,status,destination);
        }
    }

}
