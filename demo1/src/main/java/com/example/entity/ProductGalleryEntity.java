package com.example.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@ToString(exclude = "productEntity")
@Entity
@Table(name = "product_gallery")
public class ProductGalleryEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String fileTitle;

    @Column(columnDefinition = "TEXT")
    private String filePath;

}
