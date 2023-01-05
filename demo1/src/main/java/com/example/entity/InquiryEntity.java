package com.example.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "inquiry")
public class InquiryEntity extends TimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inquiryId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String contents;

    @Column(length = 100, nullable = false)
    private String writer;

    @Column(nullable = false)
    private boolean secret;

    @Column(nullable = false)
    private boolean responseState;

    //ProductEntity와 단방향
    @ManyToOne
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    private ProductEntity productEntity;

    //MemberEntity와 양방향
    @ManyToOne
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private MemberEntity memberEntity;

    //빌더 작성

}
