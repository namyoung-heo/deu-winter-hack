package com.example.demo;

import com.example.entity.*;
import com.example.repository.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class Demo1ApplicationTests {

//    @Autowired
//    UserRepository memberRepository;
//
//    @Autowired
//    AddressRepository addressRepository;
//
//    @Autowired
//    CartRepository cartRepository;
//
//    @Autowired
//    ProductRepository productRepository;
//    @Autowired
//    OrderRepository orderRepository;

    @Test
    @DisplayName("유저 배송지 여러 개 테스트")
    void contextLoads() {

//        AddressEntity address = AddressEntity.builder()
//                .address("부산시")
//                .build();
//        AddressEntity address1 = AddressEntity.builder()
//                .address("1")
//                .build();
//
//        UserEntity member = UserEntity.builder()
//                .uid("asd")
//                .password("1")
//                .name("허남영")
//                .email("@")
//                .phone("010-1111-1111")
//                .sex("남자")
//                .birth(LocalDateTime.now())
//                .build();
//
//        addressRepository.save(address);
//        addressRepository.save(address1);
//        member.setAddresses(Arrays.asList(address,address1));
//        memberRepository.save(member);
//        List<AddressEntity> addressEntities = memberRepository.findById(1L).get().getAddresses();
//        for(AddressEntity found : addressEntities){
//            AddressEntity a = addressEntities.get(0);
//            AddressEntity a1 = addressEntities.get(1);
//            System.out.println("주소"+a.getAddress());
//            System.out.println("주소"+a1.getAddress());
//            System.out.println(addressEntities);
//        }
    }
    @Test
    @DisplayName("카테고리 상품 테스트")
    void CategoryProduct() {
//        CategoryEntity category;
//        ProductEntity productEntity;
//
//        OrderEntity orderEntity;
//
//
//    }
//
//    @Test
//    @DisplayName("유저 카트 테스트")
//    void UserCartTest() {
//        ProductEntity product = ProductEntity.builder()
//                .id(1L)
//                .title("제")
//                .imageUrl("img")
//                .price(1)
//                .product_detail("a")
//                .build();
//        ProductEntity product1 = ProductEntity.builder()
//                .id(1L)
//                .title("제")
//                .imageUrl("img")
//                .price(1)
//                .product_detail("a")
//                .build();
//        UserEntity member = UserEntity.builder()
//                .uid("1")
//                .password("1")
//                .name("1")
//                .email("1")
//                .phone("0101111")
//                .sex("남자")
//                .birth(LocalDateTime.now())
//                .build();
//        UserEntity member1 = UserEntity.builder()
//                .uid("1")
//                .password("1")
//                .name("1")
//                .email("1")
//                .phone("0101111")
//                .sex("남자")
//                .birth(LocalDateTime.now())
//                .build();
//        CartEntity cart = CartEntity.builder()
//                .build();
//        CartEntity cart1 = CartEntity.builder()
//                .build();
//
//        productRepository.save(product);
//        //productRepository.save(product1);
//        memberRepository.save(member);
//        memberRepository.save(member1);
//
//
//        cart.setProductEntity(product);
//        //cart.setProductEntity(product1);
//        cart.setMemberEntity(member);
//        cart1.setProductEntity(product);
//        //cart.setProductEntity(product1);
//        cart1.setMemberEntity(member1);
//        cartRepository.save(cart);
//        cartRepository.save(cart1);
    }
}
