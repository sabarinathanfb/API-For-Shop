package com.store.UserService.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Allow all requests to the sign-up endpoint and any other public endpoints
                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/api/auth/signup").permitAll()  // Allow sign-up without auth
//                        .anyRequest().authenticated()  // Require authentication for all other requests
                                .anyRequest().permitAll()

                )
                // Disable CSRF protection
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
    @Bean
    public OncePerRequestFilter jwtAuthenticationFilter() {
        return new JWTAuthenticationFilter();
    }
}

