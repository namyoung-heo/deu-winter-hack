package com.example.dto;

import com.example.entity.ProductPageEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductPageDto {
    private Long pageId;
    private String pageImageUrl;
    private String headerDescription;
    private String headerBrand;
    private String headerProductName;
    private String detailedInfoImageUrl;

    @Builder
    public ProductPageDto(Long pageId, String pageImageUrl, String headerDescription, String headerBrand, String headerProductName, String detailedInfoImageUrl) {
        this.pageId = pageId;
        this.pageImageUrl = pageImageUrl;
        this.headerDescription = headerDescription;
        this.headerBrand = headerBrand;
        this.headerProductName = headerProductName;
        this.detailedInfoImageUrl = detailedInfoImageUrl;
    }

    public ProductPageEntity toEntity() {
        return ProductPageEntity.builder().pageId(pageId).pageImageUrl(pageImageUrl).headerDescription(headerDescription).headerBrand(headerBrand).headerProductName(headerProductName).detailedInfoImageUrl(detailedInfoImageUrl).build();
    }
}
