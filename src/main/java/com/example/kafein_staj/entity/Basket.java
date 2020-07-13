
package com.example.kafein_staj.entity;

import javax.persistence.*;

@Entity
@Table(
        name="Basket",
        uniqueConstraints = @UniqueConstraint(name = "basket_id", columnNames = {"basketId"})

)
public class Basket {
    @Id
    @GeneratedValue
    private Long basket_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Basket(Long basket_id, User user) {
        this.basket_id = basket_id;
        this.user = user;
    }

    public Long getBasket_id() {
        return basket_id;
    }

    public void setBasket_id(Long basket_id) {
        this.basket_id = basket_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
