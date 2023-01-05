package com.example.demo;

import com.example.entity.AddressEntity;
import com.example.entity.MemberEntity;
import com.example.repository.AddressRepository;
import com.example.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootTest
class Demo1ApplicationTests {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    AddressRepository addressRepository;

    @Test
    @DisplayName("유저 배송지 여러 개 테스트")
    void contextLoads() {

        AddressEntity address = AddressEntity.builder()
                .address("1")
                .build();
        AddressEntity address1 = AddressEntity.builder()
                .address("1")
                .build();

        MemberEntity member = MemberEntity.builder()
                .memberId(1L)
                .id("asd")
                .password("1")
                .name("허남영")
                .email("@")
                .phone("010-1111-1111")
                .sex("남자")
                .birth(LocalDateTime.now())
                .build();

        addressRepository.save(address);
        addressRepository.save(address1);
        member.setAddresses(Arrays.asList(address,address1));
        memberRepository.save(member);
    }

}
