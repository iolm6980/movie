package com.example.movie.security.service;

import com.example.movie.entity.Member;
import com.example.movie.repository.MemberRepository;
import com.example.movie.security.dto.AuthMemberDTO;
import com.example.movie.security.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class MovieUserDetailService implements UserDetailsService {
    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> memberOptional = memberRepository.findByMemberId(username);
        if(memberOptional.isEmpty()) return null;
        Member member = memberOptional.get();
        System.out.println("userDetailService.............." + member);
        List<GrantedAuthority> roles = new ArrayList<>();
        if(member.getRole().equals("ADMIN")) roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        AuthMemberDTO authMemberDTO = new AuthMemberDTO(
                member.getMemberId(),
                member.getPassword(),
                roles
        );
        return authMemberDTO;
    }
}
