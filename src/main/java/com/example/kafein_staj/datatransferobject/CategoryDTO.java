package com.example.kafein_staj.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {

    private Long parentId;
    private Long categoryId;
    private String title;

    public CategoryDTO(){}

    public CategoryDTO(Long parentId, Long categoryId, String title) {
        this.parentId = parentId;
        this.categoryId = categoryId;
        this.title = title;
    }

    public Long getParentId() {
        return parentId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
