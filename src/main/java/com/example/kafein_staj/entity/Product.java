package com.example.kafein_staj.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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


    public Product(Long product_id, String procudt_name, long product_price, int product_quantity, String product_destination, Category category) {
        this.product_id = product_id;
        this.procudt_name = procudt_name;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.product_destination = product_destination;
        this.category = category;
    }
}
