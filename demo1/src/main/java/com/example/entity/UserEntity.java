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
@Table(name="user")
public class UserEntity extends TimeEntity{

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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private List<AddressEntity> addresses = new ArrayList<>();


    @Builder
    public UserEntity(Long memberId, String id, String password, String name, String email,
                      String phone, String sex, LocalDateTime birth,
                      List<AddressEntity> addresses){
        this.memberId = memberId;
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.birth = birth;
        this.addresses = addresses;
    }
}
