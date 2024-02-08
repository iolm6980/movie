package com.example.movie.security.filter;

import com.example.movie.security.util.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;

@Log4j2
public class ApiCheckFilter extends OncePerRequestFilter {
    private AntPathMatcher antPathMatcher;
    private String pattern;
    private JWTUtil jwtUtil;

    public ApiCheckFilter(String pattern, JWTUtil jwtUtil){
        this.antPathMatcher = new AntPathMatcher();
        this.pattern = pattern;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(antPathMatcher.match(pattern, request.getRequestURI())){
            System.out.println("ApiCheck..............................................");

            boolean checkHeader = checkAuthHeader(request);
            System.out.println(checkHeader);
            if(checkHeader){
                filterChain.doFilter(request,response);
                return;
            } else{
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.setContentType("application/json;charset=utf-8");
                JSONObject json = new JSONObject();
                String message = "FAIL CHECK API TOKEN";
                try {
                    json.put("code", "403");
                    json.put("message", message);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                PrintWriter out = response.getWriter();
                out.print(json);
                return;
            }
        }
        filterChain.doFilter(request,response);
    }

    private boolean checkAuthHeader(HttpServletRequest request){
        boolean checkResult = false;
        String authHeader = request.getHeader("Cookie");
        System.out.println(authHeader);
        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")){
            log.info("Authorization exist: " + authHeader);
            try {
                String memberId = jwtUtil.validateAndExtract(authHeader.substring(7));
                log.info("validate result: " + memberId);
                checkResult = memberId.length() > 0;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return checkResult;
    }
}
