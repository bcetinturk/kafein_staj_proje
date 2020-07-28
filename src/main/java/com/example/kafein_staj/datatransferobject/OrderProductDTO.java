package com.example.kafein_staj.datatransferobject;

public class OrderProductDTO {
    Integer amount;
    String product_name;
    Long product_id;

    public OrderProductDTO() {
    }

    public OrderProductDTO(Integer amount, String product_name) {
        this.amount = amount;
        this.product_name = product_name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "OrderProductDTO{" +
                "amount=" + amount +
                ", productName='" + product_name + '\'' +
                ", productId=" + product_id +
                '}';
    }
}
