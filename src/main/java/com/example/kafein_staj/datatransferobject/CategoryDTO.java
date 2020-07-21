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
    public static class CategoryDTOBuilder{
        private Long category_parent_id;
        private Long category_id;
        private String title;

        public CategoryDTOBuilder(Long category_parent_id, Long category_id, String title) {
            this.category_parent_id = category_parent_id;
            this.category_id = category_id;
            this.title = title;
        }

        public CategoryDTOBuilder setCategory_parent_id(Long category_parent_id) {
            this.category_parent_id = category_parent_id;
            return this;
        }

        public CategoryDTOBuilder setCategory_id(Long category_id) {
            this.category_id = category_id;
            return this;
        }

        public CategoryDTOBuilder setTitle(String title) {
            this.title = title;
            return this;
        }
    public CategoryDTO createCategoryDTO(){
            return new CategoryDTO(category_parent_id,category_id,title);

        }
    }
}
