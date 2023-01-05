package com.example.configuration;

import com.example.dto.EntryPointErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//인증이 실패한 상황을 처리
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationEntryPoint.class);

    //클라이언트에게 응답
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException ex) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        LOGGER.info("[commence] 인증 실패로 response.sendError 발생");

        EntryPointErrorResponse entryPointErrorResponse = new EntryPointErrorResponse();
        entryPointErrorResponse.setMsg("인증이 실패하였습니다.");

        response.setStatus(401);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(objectMapper.writeValueAsString(entryPointErrorResponse));
    }
}
