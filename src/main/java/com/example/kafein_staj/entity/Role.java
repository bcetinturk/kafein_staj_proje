package com.example.kafein_staj.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long role_id;

    @Column
    @NotNull(message = "Role name can not be null!")
    private String  role_name;

    public Role(Long role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
