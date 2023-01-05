package com.example.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private MemberEntity memberEntity;

    @Builder
    public OrderEntity(Long orderId, MemberEntity memberEntity){
        this.orderId = orderId;
        this.memberEntity = memberEntity;
    }

}
