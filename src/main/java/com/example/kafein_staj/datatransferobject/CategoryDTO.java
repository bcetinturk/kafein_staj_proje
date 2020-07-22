package com.example.kafein_staj.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {

    private Long category_parent_id;
    @NotNull(message = "Category id can not be null!")
    private Long categoryId;
    @NotNull(message = "title can not be null!")
    private String title;
    public CategoryDTO(){}
    public CategoryDTO(Long category_parent_id, Long categoryId, String title) {
        this.category_parent_id = category_parent_id;
        this.categoryId = categoryId;
        this.title = title;
    }
    @JsonProperty

    public Long getCategory_parent_id() {
        return category_parent_id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setCategory_parent_id(Long category_parent_id) {
        this.category_parent_id = category_parent_id;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
