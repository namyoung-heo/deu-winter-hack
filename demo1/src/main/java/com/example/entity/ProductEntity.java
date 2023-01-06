package com.example.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "product")
public class ProductEntity extends TimeEntity {

    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String oneLineDescription;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int discountRate;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private String deliveryType;

    @Column(nullable = false)
    private String seller;

    @Column(nullable = false)
    private String packagingType;

    @Column(nullable = false)
    private String saleUnit;

    @Column(nullable = false)
    private String capacity;

    @Column(nullable = false)
    private String origin;

    //CategoryEntity랑 단방향
    @ManyToOne
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    private CategoryEntity categoryEntity;

    @OneToOne
    @JoinColumn(name = "gallery_id")
    private ProductGalleryEntity productGalleryEntity;

    @OneToOne
    @JoinColumn(name = "page_id")
    private ProductPageEntity productPageEntity;

    @Builder
    public ProductEntity(Long id, String brand, String productName, String oneLineDescription, int price, int discountRate, int stock, String deliveryType, String seller, String packagingType, String saleUnit, String capacity, String origin, CategoryEntity categoryEntity, ProductGalleryEntity productGalleryEntity, ProductPageEntity productPageEntity) {
        this.id = id;
        this.brand = brand;
        this.productName = productName;
        this.oneLineDescription = oneLineDescription;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.deliveryType = deliveryType;
        this.seller = seller;
        this.packagingType = packagingType;
        this.saleUnit = saleUnit;
        this.capacity = capacity;
        this.origin = origin;
        this.categoryEntity = categoryEntity;
        this.productGalleryEntity = productGalleryEntity;
        this.productPageEntity = productPageEntity;
    }
}
