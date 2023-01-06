package com.example.service;

import com.example.dto.SignInResultDto;
import com.example.dto.SignUpResultDto;

public interface SignService {
    SignUpResultDto signUp(String id, String password, String name, String role);

    SignInResultDto signIn(String id, String password) throws RuntimeException;

    String idCheck(String uid);
}
