package com.example.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@ToString(exclude = "productEntity")
@Entity
@Table(name = "product_page")
public class ProductPageEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long pageId;

    @Column(length = 1000)
    private String pageImageUrl;

    @Column(nullable = false)
    private String headerDescription;

    @Column(nullable = false)
    private String headerBrand;

    @Column(nullable = false)
    private String headerProductName;

    @Column(length = 1000)
    private String detailedInfoImageUrl;

    @Builder
    public ProductPageEntity(Long pageId, String pageImageUrl, String headerDescription, String headerBrand, String headerProductName, String detailedInfoImageUrl) {
        this.pageId = pageId;
        this.pageImageUrl = pageImageUrl;
        this.headerDescription = headerDescription;
        this.headerBrand = headerBrand;
        this.headerProductName = headerProductName;
        this.detailedInfoImageUrl = detailedInfoImageUrl;
    }
}
