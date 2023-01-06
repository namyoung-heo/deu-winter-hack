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
    private Long galleryId;

    @Column(length = 1000)
    private String galleryImageUrl;

    @Builder
    public ProductGalleryEntity(Long galleryId, String galleryImageUrl) {
        this.galleryId = galleryId;
        this.galleryImageUrl = galleryImageUrl;
    }
}
