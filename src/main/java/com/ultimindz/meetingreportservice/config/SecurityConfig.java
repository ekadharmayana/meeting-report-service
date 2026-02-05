package com.ultimindz.meetingreportservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                // For REST APIs in Dev mode: Disable CSRF (otherwise POST/PUT/DELETE is annoying)
                .csrf(csrf -> csrf.disable())

                // Allow Swagger + Meetings API initially without login
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/actuator/health",
                                "/meetings/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )

                // Default Basic Auth (only if test other endpoints later)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
