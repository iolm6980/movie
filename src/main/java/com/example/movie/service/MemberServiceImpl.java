package com.example.movie.service;

import com.example.movie.dto.MemberDTO;
import com.example.movie.entity.Member;
import com.example.movie.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public boolean memberRegister(MemberDTO memberDTO) {
        if(memberRepository.findByMemberId(memberDTO.getMemberId()).isPresent()) return false;
        memberRepository.save(DtoToEntity(memberDTO, passwordEncoder));
        return true;
    }

    @Override
    public MemberDTO getMember(String memberId) {
        Optional<Member> optionalMember = memberRepository.findByMemberId(memberId);
        MemberDTO member = entityToDTO(optionalMember.get());
        return member;
    }

    @Override
    public boolean checkMember(MemberDTO memberDTO) {
        Optional<Member> optionalMember = memberRepository.findByMemberId(memberDTO.getMemberId());
        if(optionalMember.isPresent() && passwordEncoder.matches(memberDTO.getPassword(), optionalMember.get().getPassword())) return true;
        return false;
    }
}
