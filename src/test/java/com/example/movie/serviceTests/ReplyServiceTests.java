package com.example.movie.serviceTests;

import com.example.movie.dto.MemberDTO;
import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.PageResultDTO;
import com.example.movie.dto.ReplyDTO;
import com.example.movie.service.GradeService;
import com.example.movie.service.ReplyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReplyServiceTests {
    @Autowired
    private ReplyService replyService;
    @Autowired
    private GradeService gradeService;

    @Test
    public void getReplyTest(){
        System.out.println(replyService.getReplyList(1L, 0).getDtoList());

    }

    @Test
    public void registerTest(){
        MemberDTO memberDTO = MemberDTO.builder().memberId("test2").build();
        MovieDTO movieDTO = MovieDTO.builder().mno(1L).build();
        ReplyDTO replyDTO = ReplyDTO.builder().movieDTO(movieDTO)
                .memberDTO(memberDTO)
                .grade(50L)
                .content("서비스 테스트")
                .build();
        gradeService.updateMovieGrade(replyDTO);
    }

}
