package com.example.movie.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@Log4j2
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();};

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( requests ->
                        requests.requestMatchers("/movie/list").permitAll()
                                .requestMatchers("/reply/**").hasRole("USER")
                                .requestMatchers("/reply/register").hasRole("USER")
                                .requestMatchers("/pay/**").hasRole("USER")
                                .requestMatchers("/movie/**").hasRole("USER")
                                .requestMatchers("/css/**","/js/**", "/img/**").permitAll()
                                )

                .csrf((csrf) -> csrf.disable())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
