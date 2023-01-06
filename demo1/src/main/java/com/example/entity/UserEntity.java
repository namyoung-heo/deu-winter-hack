package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="user")
public class UserEntity extends TimeEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userId;

    @Column (nullable = false, unique = true)
    private String uid;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column
    private String password;

    @Column (nullable = false)
    private String name;

    @ElementCollection(fetch =  FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @JsonProperty(access =  JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getUsername(){
        return this.uid;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @Override
    public boolean isEnabled(){
        return true;
    }

    @Column(length = 100)
    private String email;

    @Column(length = 100)
    private String phone;

    @Column(length = 100)
    private String sex;

    @Column(length = 100)
    private LocalDateTime birth;

//    //AddressEntity와 단방향
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
//    @ToString.Exclude
//    private List<AddressEntity> addresses = new ArrayList<>();
//
//    //MemberEntity 양방향
//    @OneToMany(mappedBy = "userEntity")
//    //@JoinColumn(name="member_id")
//    private List<CartEntity> carts = new ArrayList<>();
//
//    @OneToMany(mappedBy = "userEntity")
//    private List<OrderEntity> orders = new ArrayList<>();

    //InquiryEntity와 양방향


//    @Builder
//   public UserEntity(Long userId, String uid, String password, String name, String email,
//                      String phone, String sex, LocalDateTime birth,
//                      List<String> roles,
//                      List<AddressEntity> addresses,
//                      List<CartEntity> carts,
//                      List<OrderEntity> orders){
//        this.userId = userId;
//        this.uid = uid;
//        this.password = password;
//        this.name = name;
//        this.email = email;
//        this.phone = phone;
//        this.sex = sex;
//        this.birth = birth;
//        this.addresses = addresses;
//        this.carts = carts;
//        this.orders = orders;
//        this.roles = roles;
//    }
}
