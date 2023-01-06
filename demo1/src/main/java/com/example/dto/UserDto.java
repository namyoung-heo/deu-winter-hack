package com.example.dto;

import com.example.entity.UserEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserDto {
    private Long userId;
    private String uid;
    private String password;
    private String name;
    private List<String> roles;
    private String email;
    private String phone;
    private String sex;
    private LocalDateTime birth;
    public UserEntity toEntity(){
        UserEntity userEntity = UserEntity.builder()
                .userId(userId)
                .uid(uid)
                .password(password)
                .name(name)
                .roles(roles)
//                .email(email)
//                .phone(phone)
//                .sex(sex)
//                .birth(birth)
                .build();
        return userEntity;
    }
}
