package com.UserLogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity httpSecurity
    ) throws Exception {
        httpSecurity.csrf().disable().cors().disable();

        httpSecurity.authorizeHttpRequests()
                .requestMatchers("/api/v1/user/signup", "/api/v1/user/login").permitAll()
                .anyRequest().authenticated();
        return httpSecurity.build();
    }

}
