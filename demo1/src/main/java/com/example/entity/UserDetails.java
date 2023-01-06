package com.example.entity;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public interface UserDetails extends Serializable {

    //계정이 가지고 있는 권한 목록을 리턴
    Collection<? extends GrantedAuthority> getAuthorities();

    //계정의 비밀번호를 리턴
    String getPassword();

    //계정의 이름을 리턴 아이디를 리턴,uid리턴
    String getUsername();

    //계정이 만료됐는지 리턴 true는 만료되지 않았다는 의미
    boolean isAccountNonExpired();

    //계정이 잠겨있는지 리턴 true는 잠기지 않았다는 의미
    boolean isAccountNonLocked();

    //비밀번호가 만료됐는지 리턴 true는 만료되지 않았다는 의미
    boolean isCredentialsNonExpired();

    //계정이 활성화돼 있는지 리턴 true는 활성화 상태를 의미
    boolean isEnabled();
}
