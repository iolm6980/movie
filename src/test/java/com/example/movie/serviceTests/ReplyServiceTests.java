package com.example.movie.serviceTests;

import com.example.movie.dto.PageResultDTO;
import com.example.movie.service.ReplyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReplyServiceTests {
    @Autowired
    private ReplyService replyService;

    @Test
    public void getReplyTest(){
        System.out.println(replyService.getReplyList(1L, 0).getDtoList());

    }
}
