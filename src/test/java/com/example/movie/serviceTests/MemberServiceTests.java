package com.example.movie.serviceTests;

import com.example.movie.dto.MemberDTO;
import com.example.movie.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTests {
    @Autowired
    private MemberService memberService;

    @Test
    public void memberResister() throws Exception {
        memberService.test();
    }
}
