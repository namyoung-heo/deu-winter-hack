package com.example.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "review")
public class ReviewEntity extends TimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(length = 100, nullable = false)
    private Long recommendNum;

    @Column(length = 100, nullable = false)
    private String contents;
}
