package com.example.kafein_staj.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message="Name can not be null!")
    private String firstName;

    @Column(nullable = false)
    @NotNull(message="Lastname can not be null!")
    private String lastName;

    @Column(nullable = false, unique = true)
    @NotNull(message="Email can not be null!")
    private String email;

    @Column(nullable = false, unique = true)
    @NotNull(message = "phone can not be null!")
    private String phoneNumber;

    @Column(nullable = false)
    @NotNull(message = "Address can not be null!")
    private String address;

    @Enumerated
    private Role role;

    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Basket basket;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Order> orders = new ArrayList<>();

    public User() {
    }


    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String firstName, String user_lastname, String user_mail, String user_number, String address, Role role, String password, Basket basket) {
       this.id = id;
        this.firstName = firstName;
        this.lastName = user_lastname;
        this.email = user_mail;
        this.phoneNumber = user_number;
        this.address = address;
        this.role = role;
        this.password = password;
        this.basket = basket;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long user_id) {
        this.id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String user_name) {
        this.firstName = user_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String user_lastname) {
        this.lastName = user_lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String user_mail) {
        this.email = user_mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String user_number) {
        this.phoneNumber = user_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String user_address) {
        this.address = user_address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", role=" + role +
                ", basket=" + basket +
                '}';
    }
}
