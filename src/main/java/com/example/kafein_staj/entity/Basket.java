
package com.example.kafein_staj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Basket {
    @Id
    @GeneratedValue
    private Long basketId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "basket")
    private List<BasketProduct> products = new ArrayList<>();

    public Basket(Long basket_id, User user) {
        this.basketId = basket_id;
        this.user = user;
    }

    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basket_id) {
        this.basketId = basket_id;
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
