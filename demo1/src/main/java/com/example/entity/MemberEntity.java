package com.example.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name="member")
public class MemberEntity extends TimeEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 100, nullable = false)
    private String id;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String phone;

    @Column(length = 100, nullable = false)
    private String sex;


    @Column(length = 100, nullable = false)
    private LocalDateTime birth;

    //AddressEntity와 단방향
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_member_id")
    @ToString.Exclude
    private List<AddressEntity> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "memberEntity", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<CartEntity> carts = new ArrayList<>();

    //InquiryEntity와 양방향


    @Builder
    public MemberEntity(Long memberId, String id, String password, String name, String email,
                        String phone, String sex, LocalDateTime birth,
                        List<AddressEntity> addresses,
                        List<CartEntity> carts){
        this.memberId = memberId;
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.birth = birth;
        this.addresses = addresses;
        this.carts = carts;
    }
}
