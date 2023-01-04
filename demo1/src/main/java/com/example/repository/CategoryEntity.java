package com.example.repository;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column
    private String categoryName;

    @Builder
    public CategoryEntity(Long categoryId, String categoryName){
        this.categoryId = categoryId;
        this.categoryName = categoryName;

    }
}
