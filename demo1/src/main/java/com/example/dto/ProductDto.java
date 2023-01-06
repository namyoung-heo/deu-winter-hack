package com.example.dto;

import com.example.entity.OrderEntity;
import com.example.entity.ProductEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String categoryId;
    private String brand;
    private String productName;
    private String oneLineDescription;
    private int price;
    private int discountRate;
    private int stock;
    private String deliveryType;
    private String seller;
    private String packagingType;
    private String saleUnit;
    private String capacity;
    private String origin;

    @Builder
    public ProductDto(Long id, String categoryId, String brand, String productName, String oneLineDescription, int price, int discountRate, int stock, String deliveryType, String seller, String packagingType, String saleUnit, String capacity, String origin) {
        this.id = id;
        this.categoryId = categoryId;
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
    }

    public ProductEntity toEntity() {
        return ProductEntity.builder().id(id).categoryId(categoryId).brand(brand).productName(productName).oneLineDescription(oneLineDescription).price(price).discountRate(discountRate).stock(stock).deliveryType(deliveryType).seller(seller).packagingType(packagingType).saleUnit(saleUnit).capacity(capacity).origin(origin).build();
    }
}
