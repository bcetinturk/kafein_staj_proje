package com.example.kafein_staj.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(
        name = "Category",
        uniqueConstraints = @UniqueConstraint(name = "role_id", columnNames = {"roleId"})
)
public class Category {
    @Id
    @GeneratedValue
    private Long category_parent_id;

    @Id
    @GeneratedValue
    private Long category_id;

    @Column(nullable = false)
    @NotNull(message = "title can not be null!")
    private String title;

    public Category(Long category_parent_id, Long category_id, String title) {
        this.category_parent_id = category_parent_id;
        this.category_id = category_id;
        this.title = title;
    }

    public Long getCategory_parent_id() {
        return category_parent_id;
    }

    public void setCategory_parent_id(Long category_parent_id) {
        this.category_parent_id = category_parent_id;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

