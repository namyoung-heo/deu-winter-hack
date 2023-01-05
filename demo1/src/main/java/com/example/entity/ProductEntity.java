package com.example.entity;


import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "product")
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

    //CategoryEntity랑 단방향
    @ManyToOne
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    private CartEntity cartEntity;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ProductGalleryEntity> gallery = new ArrayList<>();

    //빌더 작성 요망
}
