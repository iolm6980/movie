package com.example.movie.security.filter;

import com.example.movie.security.dto.AuthMemberDTO;
import com.example.movie.security.util.JwtTokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import java.util.*;

@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
    private final UserDetailsService userDetailsService;
    private final String secretKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("jwtFilterStart.................");
        String authorizationHeader = request.getHeader("Authentication");
        System.out.println("authorizationHeader........" + authorizationHeader);


        if(authorizationHeader == null){
            filterChain.doFilter(request, response);
            return;
        }

        if(!authorizationHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        String token = authorizationHeader.split(" ")[1];
        System.out.println("isExpired......." + JwtTokenUtil.isExpired(token, secretKey));
        System.out.println("startsWith......." + JwtTokenUtil.isExpired(token, secretKey));

        if(JwtTokenUtil.isExpired(token, secretKey)){
            filterChain.doFilter(request, response);
            return;
        }
        System.out.println("jwtFilter1.................");
        String memberId = JwtTokenUtil.getMemberId(token, secretKey);
        AuthMemberDTO authMemberDTO = (AuthMemberDTO) userDetailsService.loadUserByUsername(memberId);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authMemberDTO.getUsername(), null, List.of(new SimpleGrantedAuthority(authMemberDTO.getAuthorities().toString())));
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
