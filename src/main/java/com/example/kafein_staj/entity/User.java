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
    private String firstName;

    @Column(nullable = false)
    @NotNull(message="Lastname can not be null!")
    private String lastName;

    @Column(nullable = false)
    @NotNull(message="Email can not be null!")
    private String email;

    @Column(nullable = false)
    @NotNull(message = "phone can not be null!")
    private long phoneNumber;

    @Column(nullable = false)
    @NotNull(message = "Address can not be null!")
    private String address;

    @Enumerated
    private Role role;

    @OneToOne(mappedBy = "user")
    private Basket basket;


    public User(Long id, String firstName, String user_lastname, String user_mail, long user_number, String address, Role role) {
        this.user_id = id;
        this.firstName = firstName;
        this.lastName = user_lastname;
        this.email = user_mail;
        this.phoneNumber = user_number;
        this.address = address;
        this.role = role;
    }

    public Long getId() {
        return user_id;
    }

    public void setId(Long user_id) {
        this.user_id = user_id;
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long user_number) {
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
}
