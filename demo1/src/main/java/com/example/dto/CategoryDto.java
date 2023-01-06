package com.example.dto;

import com.example.entity.CategoryEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryDto {
    private Long categoryId;
    private String categoryName;

    @Builder
    public CategoryDto(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public CategoryEntity toEntity() {
        return CategoryEntity.builder().categoryId(categoryId).categoryName(categoryName).build();
    }
}
