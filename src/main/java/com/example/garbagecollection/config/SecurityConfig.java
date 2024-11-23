package com.example.garbagecollection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-resources/**",
                                "/webjars/**",
                                "/console/**"
                        ).permitAll() // No login required for these paths
                        .anyRequest().authenticated() // Secure other endpoints
                )
                .csrf(csrf -> csrf.ignoringRequestMatchers("/console/**")) // Disable CSRF for H2 Console
                .headers(headers -> headers.frameOptions().disable()) // Allow H2 Console frames
                .httpBasic(); // Use basic authentication for other endpoints

        return http.build();
    }
}
