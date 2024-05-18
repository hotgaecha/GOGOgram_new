package com.example.nonogram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeRequests(authorizeRequests ->
						authorizeRequests
								.mvcMatchers("/", "/game/**", "/css/**").permitAll() // 공개 접근 허용 경로
								.anyRequest().authenticated()
				)
				.formLogin(form -> form.disable()) // 폼 로그인 비활성화
				.httpBasic(httpBasic -> httpBasic.disable()); // HTTP 기본 인증 비활성화

		return http.build();
	}
}
