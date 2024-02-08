package com.example.movie.security.config;

import com.example.movie.security.filter.ApiCheckFilter;
import com.example.movie.security.filter.ApiLoginFilter;
import com.example.movie.security.filter.JwtTokenFilter;
import com.example.movie.security.handler.ApiLoginFailHandler;
import com.example.movie.security.handler.LoginSuccessHandler;
import com.example.movie.security.handler.MovieFailHandler;
import com.example.movie.security.service.MovieUserDetailService;
import com.example.movie.security.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@Log4j2
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {
    private final MovieUserDetailService movieUserDetailService;
    private final MovieFailHandler movieFailHandler;
    String secretKey = "1111";
    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();};
    @Bean
    public ApiCheckFilter apiCheckFilter(){ return new ApiCheckFilter("", jwtUtil());}

    @Bean
    public JWTUtil jwtUtil() {
        return new JWTUtil();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("filter............");
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(movieUserDetailService).passwordEncoder(passwordEncoder());
        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
        http.authenticationManager(authenticationManager);

        http.authorizeHttpRequests(requests -> requests.requestMatchers("/**").permitAll()
//                        requests.requestMatchers("/movie/list").permitAll()
//                                .requestMatchers("/movie/**").hasRole("USER")
//                                .requestMatchers("/movie/movieRegister").hasRole("ADMIN")
//                                .requestMatchers("/reply/**").hasRole("USER")
//                                .requestMatchers("/pay/**").hasRole("USER")
//                                .requestMatchers("/logout").hasRole("USER")
//                                .requestMatchers("/member/**").permitAll()
//                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/css/**","/js/**", "/img/**").permitAll()
                                )
                .csrf((csrf) -> csrf.disable())
                .formLogin(login -> login.loginPage("/member/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/movie/list")
                        //.successHandler(loginSuccessHandler())
                        .failureHandler(movieFailHandler).permitAll())
                .logout(Customizer.withDefaults())
                .addFilterBefore(apiCheckFilter(), UsernamePasswordAuthenticationFilter.class);
                //.addFilterBefore(apiLoginFilter(authenticationManager), UsernamePasswordAuthenticationFilter.class)
                //.addFilterBefore(new JwtTokenFilter(movieUserDetailService, secretKey), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    public ApiLoginFilter apiLoginFilter(AuthenticationManager authenticationManager) throws Exception{
        ApiLoginFilter apiLoginFilter = new ApiLoginFilter("/api/login", jwtUtil());
        apiLoginFilter.setAuthenticationManager(authenticationManager);
        return apiLoginFilter;
    }
    public LoginSuccessHandler loginSuccessHandler(){ return new LoginSuccessHandler(jwtUtil()); }
}
