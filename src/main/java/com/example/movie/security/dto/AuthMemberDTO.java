package com.example.movie.security.dto;

import com.example.movie.security.util.JWTUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class AuthMemberDTO extends User {
    private String memberId;
    private String password;

    public AuthMemberDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.memberId = username;
    }
}
