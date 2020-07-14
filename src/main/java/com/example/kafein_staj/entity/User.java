package com.example.kafein_staj.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class User {
    @Id
    @GeneratedValue
    private Long user_id;

    @Column(nullable = false)
    @NotNull(message="Name can not be null!")
    private String user_name;

    @Column(nullable = false)
    @NotNull(message="Lastname can not be null!")
    private String user_lastname;

    @Column(nullable = false)
    @NotNull(message="Email can not be null!")
    private String user_mail;

    @Column(nullable = false)
    @NotNull(message = "phone can not be null!")
    private long user_number;

    @Column(nullable = false)
    @NotNull(message = "Address can not be null!")
    private String user_address;

    @Enumerated
    private Role role;

    @OneToOne(mappedBy = "user")
    private Basket basket;


    public User(Long user_id, String user_name, String user_lastname, String user_mail, long user_number, String user_address, Role role) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_lastname = user_lastname;
        this.user_mail = user_mail;
        this.user_number = user_number;
        this.user_address = user_address;
        this.role = role;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public long getUser_number() {
        return user_number;
    }

    public void setUser_number(long user_number) {
        this.user_number = user_number;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
