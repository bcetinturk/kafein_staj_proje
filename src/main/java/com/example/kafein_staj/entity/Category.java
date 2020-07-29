package com.example.kafein_staj.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Category {
    private Long categoryParentId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(nullable = false)
    @NotNull(message = "title can not be null!")
    private String title;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

    public Category() {
    }

    public Category(Long categoryParentId, Long categoryId, String title) {
        this.categoryParentId = categoryParentId;
        this.categoryId = categoryId;
        this.title = title;
    }

    public Long getCategoryParentId() {
        return categoryParentId;
    }

    public void setCategoryParentId(Long category_parent_id) {
        this.categoryParentId = category_parent_id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long category_id) {
        this.categoryId = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryParentId=" + categoryParentId +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                '}';
    }
}

