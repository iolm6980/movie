package com.example.movie.security.filter;

import com.example.movie.security.dto.AuthMemberDTO;
import com.example.movie.security.util.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import java.io.IOException;

public class ApiLoginFilter extends AbstractAuthenticationProcessingFilter {
    private JWTUtil jwtUtil;
    public ApiLoginFilter(String defaultFilterProcessesUrl, JWTUtil jwtUtil){
        super(defaultFilterProcessesUrl);
        this.jwtUtil = jwtUtil;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        System.out.println("apiLoginFilter.......................");

        String memberId = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("memberId:" + memberId + " password: " + password);

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(memberId, password);
        return getAuthenticationManager().authenticate(authToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)throws IOException, ServletException{
        System.out.println("--------------api login filter----------------");
        System.out.println("success authentication" + authResult);

        System.out.println(authResult.getPrincipal());

        String memberId = ((AuthMemberDTO)authResult.getPrincipal()).getUsername();

        String token = null;
        try{
            token = jwtUtil.generateToken(memberId);
            response.setContentType("text/plain");
            response.setHeader("authentication", token);
            response.getOutputStream().write(token.getBytes());
            System.out.println(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
