package com.example.movie.repositoryTests;

import com.example.movie.entity.Member;
import com.example.movie.repository.MemberRepository;
import com.example.movie.repository.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void MemberInsertTest(){
        IntStream.rangeClosed(1, 10).forEach(i ->{
            Member member = Member.builder()
                    .memberId("test" +i)
                    .build();
            memberRepository.save(member);
        });
    }

    @Test
    public void test(){
        String s = "01.23 21:28";
        SimpleDateFormat formatter = new SimpleDateFormat ( "MM.dd HH:mm");
        Date currentTime = new Date ();
        //String dTime = formatter.format ( currentTime );
        log.info(currentTime);
    }
}
