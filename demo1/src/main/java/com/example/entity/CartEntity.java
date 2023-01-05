package com.example.entity;

import lombok.*;
import org.apache.catalina.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "cart")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    //사용자와 단방향
    @ManyToOne
    @JoinColumn(name = "member_member_id")
    @ToString.Exclude
    private MemberEntity memberEntity;

    //상품과 단방향
    @ManyToOne
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    private ProductEntity productEntity;

    @Builder
    public CartEntity(Long cartId, MemberEntity memberEntity,ProductEntity productEntity){
        this.cartId = cartId;
        this.memberEntity = memberEntity;
        this.productEntity = productEntity;
    }
}
