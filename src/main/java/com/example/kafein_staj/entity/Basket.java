
package com.example.kafein_staj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Basket {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BasketProduct> products = new ArrayList<>();

    public Basket() {
    }

    public Basket(Long basket_id, User user) {
        this.id = basket_id;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long basket_id) {
        this.id = basket_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BasketProduct> getProducts() {
        return products;
    }

    public void setProducts(List<BasketProduct> products) {
        this.products = products;
    }
}
