package com.example.movie.service;

import com.example.movie.dto.MemberDTO;
import com.example.movie.entity.Member;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface MemberService {
    boolean memberRegister(MemberDTO memberDTO);
    MemberDTO getMember(String memberId);
    boolean checkMember(MemberDTO memberDTO);

    default Member DtoToEntity(MemberDTO memberDTO, PasswordEncoder passwordEncoder){
        Member member = Member.builder()
                .memberId(memberDTO.getMemberId())
                .password(passwordEncoder.encode(memberDTO.getPassword()))
                .role("USER")
                .build();
        return member;
    }

    default MemberDTO entityToDTO(Member member){
        MemberDTO memberDTO = MemberDTO.builder()
                .memberId(member.getMemberId())
                .role(member.getRole())
                .build();
        return memberDTO;
    }
}
