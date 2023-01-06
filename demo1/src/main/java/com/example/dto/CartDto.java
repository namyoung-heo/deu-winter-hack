package com.example.dto;

import com.example.entity.CartEntity;
import com.example.entity.MemberEntity;
import com.example.entity.ProductEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class CartDto {
    private Long cartId;
    private MemberEntity memberEntity;
    private ProductEntity productEntity;

    @Builder
    public CartDto(Long cartId, MemberEntity memberEntity, ProductEntity productEntity) {
        this.cartId = cartId;
        this.memberEntity = memberEntity;
        this.productEntity = productEntity;
    }

    public CartEntity toEntity() {
        return CartEntity.builder().cartId(cartId).memberEntity(memberEntity).productEntity(productEntity).build();
    }
}
