package com.example.dto;

import com.example.entity.ProductGalleryEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductGalleryDto {
    private Long galleryId;
    private String galleryImageUrl;

    @Builder
    public ProductGalleryDto(Long galleryId, String galleryImageUrl) {
        this.galleryId = galleryId;
        this.galleryImageUrl = galleryImageUrl;
    }

    public ProductGalleryEntity toEntity() {
        return ProductGalleryEntity.builder().galleryId(galleryId).galleryImageUrl(galleryImageUrl).build();
    }
}
