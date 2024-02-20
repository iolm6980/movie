package com.example.movie.repositoryTests;

import com.example.movie.entity.Member;
import com.example.movie.repository.MemberRepository;
import com.example.movie.repository.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    public void MemberInsertTest(){
        Member admin = Member.builder()
                .memberId("admin")
                .password(passwordEncoder.encode("1111"))
                .role("ADMIN")
                .build();
        memberRepository.save(admin);

        IntStream.rangeClosed(1, 5).forEach(i ->{
            Member member = Member.builder()
                    .memberId("test" +i)
                    .password(passwordEncoder.encode("1111"))
                    .role("USER")
                    .build();
            memberRepository.save(member);
        });
    }

    @Test
    public void test() throws Exception {
        Member admin = Member.builder()
                .memberId("3")
                .password(passwordEncoder.encode("1111"))
                .role("ADMIN")
                .build();
        memberRepository.save(admin);
        //throw new Exception();
    }
}
