package com.example.service;

import com.example.common.CommonResponse;
import com.example.dto.SignInResultDto;
import com.example.dto.SignUpResultDto;
import com.example.entity.UserEntity;
import com.example.jwt.JwtTokenProvider;
import com.example.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class SignServiceImpl implements SignService{

    private final Logger LOGGER = LoggerFactory.getLogger(SignServiceImpl.class);

    public UserRepository userRepository;
    public JwtTokenProvider jwtTokenProvider;
    public PasswordEncoder passwordEncoder;

    //회원가입과 로그인 위한 의존성 주입받음
    @Autowired
    public SignServiceImpl(UserRepository userRepository, JwtTokenProvider jwtTokenProvider,
                       PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }
    //회원가입과 구현
    @Override
    public SignUpResultDto signUp(String id, String password, String name, String role){
        LOGGER.info("[getSignUpResult] 회원 가입 정보 전달");
        UserEntity user;
        if(role.equalsIgnoreCase("admin")){
            user = UserEntity.builder()
                    .uid(id)
                    .name(name)
                    .password(passwordEncoder.encode(password))
                    .roles(Collections.singletonList("ROLE_ADMIN"))
                    .build();
        } else {
            user = UserEntity.builder()
                    .uid(id)
                    .name(name)
                    .password(passwordEncoder.encode(password))
                    .roles(Collections.singletonList("ROLE_USER"))
                    .build();
        }
        UserEntity savedUser = userRepository.save(user);
        SignUpResultDto signUpResultDto = new SignInResultDto();

        LOGGER.info("[getSignUpResult] userEntity 값이 들어왔는지 확인 후 결과 값 주입");
        if(!savedUser.getName().isEmpty()) {
            LOGGER.info("[getSignUpResult] 정상 처리 완료");
            setSuccesResult(signUpResultDto);
        } else {
          LOGGER.info("[getSignUPResult] 실패 처리 완료");
          setFailResult(signUpResultDto);
        }
        return  signUpResultDto;
    }

    //로그인
    @Override
    public SignInResultDto signIn(String id, String password) throws RuntimeException{
        LOGGER.info("getSignInResult] signDataHandler 로 회원 정보 요청");
        UserEntity user = userRepository.getByUid(id);
        LOGGER.info("[getSignInResult] Id : {}", id);

        LOGGER.info("[getSignInResult] 패스워드 비교 수행");
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new RuntimeException();
        }
        LOGGER.info("[getSignInResult] 패스워드 일치");

        LOGGER.info("[getSignInResult] SignInResultDto 객체 생성");
        SignInResultDto signInResultDto = SignInResultDto.builder()
                .token(jwtTokenProvider.creteToken(String.valueOf(user.getUid()),
                        user.getRoles()))
                .build();

        LOGGER.info("[getSignInResult] SignInResultDto 객체에 값 주입");
        setSuccesResult(signInResultDto);

        return signInResultDto;
    }

    private void setSuccesResult(SignUpResultDto result){
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }
    private void setFailResult(SignUpResultDto result){
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
    }

}
