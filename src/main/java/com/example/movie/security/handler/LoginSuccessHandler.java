package com.example.movie.security.handler;

import com.example.movie.security.dto.AuthMemberDTO;
import com.example.movie.security.util.JWTUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler{
    private JWTUtil jwtUtil;
    public LoginSuccessHandler(JWTUtil jwtUtil){
        this.jwtUtil = jwtUtil;
    }
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("login success..............");
        String memberId = ((AuthMemberDTO)authentication.getPrincipal()).getUsername();

        String token = null;
        try{
            token = jwtUtil.generateToken(memberId);
            response.setContentType("text/plain");
            response.setHeader("authentication", token);
            System.out.println(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/movie/list");
    }
}
