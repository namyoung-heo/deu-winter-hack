package com.example.configuration;

import com.example.jwt.JwtAuthenticationFilter;
import com.example.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity //웹보안 활성화를위한 annotation
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public SecurityConfiguration(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider = jwtTokenProvider;
    }

    //HttpSecurity로 설정
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic().disable()//UI사용 비활성화

                .csrf().disable()//csrf비활성화

                .sessionManagement()
                .sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS)//세션스테이트리스
                .and()
                .authorizeRequests()//애플리케이션에 들어오는 요청에대한 사용권한 체크
                .antMatchers("/sign-api/sign-in","/sign-api/sign-up","sign-api/exception").permitAll()
                .antMatchers(HttpMethod.GET,"/product/**").permitAll()
                .antMatchers("**exception**").permitAll()
                .anyRequest().hasRole("ADMIN")//기타요청은 권한을 가진 사용자에게 허용
                .and()
                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())//권한을 확인하는 과정에서 통과하지 못하는 예외가 발생할 경우 예외를 전달한다
                .and()
                .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint())//인증과정에서 예외가 발생할 경우 예외를 전달한다.

                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class);
       //http
                //.authorizeRequests()
                //.anyRequest().authenticated()
                //.and()
                //.formLogin()//Form 로그인 인증 기능이 작동함
                //.loginPage("/login.html")//사용자 정의 로그인 페이지
                //.defaultSuccessUrl("/home")//로그인 성공 후 이동 페이지
                //.failureUrl("/login.html?error=true")// 로그인 실패 후 이동 페이지
                //.usernameParameter("username")//아이디 파라미터명 설정
                //.passwordParameter("password")//패스워드 파라미터명 설정
                //.loginProcessingUrl("/login");//로그인 Form Action Url
                //.successHandler(loginSuccessHandler())//로그인 성공 후 핸들러 (해당 핸들러를 생성하여 핸들링 해준다.)
                //.failureHandler(loginFailureHandler());//로그인 실패 후 핸들러 (해당 핸들러를 생성하여 핸들링 해준다.)
							//.permitAll(); //사용자 정의 로그인 페이지 접근 권한 승인
    }
    //스프링 시큐리티 영향권밖 인증인가 전에 동작 인증인가 무시
    @Override
    public void configure(WebSecurity webSecurity){
        webSecurity.ignoring().antMatchers("/v2/api-docs","/swagger-resources/**",
                "/swagger-ui.html","/webjars/**","/swagger/**", "/sign-api/exception");
    }
}
