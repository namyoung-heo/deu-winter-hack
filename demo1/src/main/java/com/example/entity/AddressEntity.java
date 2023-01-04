package com.example.entity;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long addressId;

    @Column(length = 200, nullable = false)
    private String address;

    @Builder
    public AddressEntity(Long addressId,String address){
        this.addressId = addressId;
        this.address = address;
    }
}
