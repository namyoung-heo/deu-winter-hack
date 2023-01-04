package com.example.repository;


import lombok.*;
import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class ProductEntity extends TimeEntity {

    @Id
    @Column(name = "product_id", nullable = false )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String imageUrl;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String product_detail;
}
