package com.example.collegeevents.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Demo accounts. Passwords come from the environment variables ADMIN_PASSWORD and
     * STUDENT_PASSWORD (see application.properties). They are never stored in source code.
     */
    @Bean
    public UserDetailsService userDetailsService(
            PasswordEncoder encoder,
            @Value("${app.security.admin-password}") String adminPassword,
            @Value("${app.security.student-password}") String studentPassword) {

        requirePassword("ADMIN_PASSWORD", adminPassword);
        requirePassword("STUDENT_PASSWORD", studentPassword);

        var admin = User.builder()
                .username("admin")
                .password(encoder.encode(adminPassword))
                .roles("ADMIN")
                .build();

        var student = User.builder()
                .username("student")
                .password(encoder.encode(studentPassword))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, student);
    }

    private static void requirePassword(String variableName, String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Environment variable " + variableName + " is not set. "
                    + "Set it to a strong password before starting the application.");
        }
        if (value.length() < 8) {
            throw new IllegalStateException(variableName + " must be at least 8 characters long.");
        }
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/css/**", "/images/**", "/login", "/error").permitAll()
                .anyRequest().authenticated()
            )
            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }
}
