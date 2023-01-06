package com.example.dto;

import com.example.entity.MemberEntity;
import com.example.entity.OrderEntity;
import com.example.entity.ProductEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderDto {
    private Long orderId;
    private MemberEntity memberEntity;
    private ProductEntity productEntity;

    @Builder
    public OrderDto(Long orderId, MemberEntity memberEntity, ProductEntity productEntity) {
        this.orderId = orderId;
        this.memberEntity = memberEntity;
        this.productEntity = productEntity;
    }

    public OrderEntity toEntity() {
        return OrderEntity.builder().orderId(orderId).memberEntity(memberEntity).productEntity(productEntity).build();
    }

}
