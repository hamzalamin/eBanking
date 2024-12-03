package com.wora.ebanking.security.config;

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
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/api/notices").permitAll()
                .requestMatchers("/api/card").hasRole("USER")
                .requestMatchers("/api/users").hasRole("ADMIN")
                .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> httpBasic.init(http));
        return http.build();
    }

}
