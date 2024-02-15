package com.example.movie.repositoryTests;

import com.example.movie.dto.ReplyDTO;

import com.example.movie.entity.Member;
import com.example.movie.entity.Movie;
import com.example.movie.entity.Reply;
import com.example.movie.repository.MovieRepository;
import com.example.movie.repository.ReplyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;

@SpringBootTest
public class ReplyRepositoryTests {
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void ReplyInsertTest(){
        IntStream.rangeClosed(1, 50).forEach(i ->{
            Movie movie = Movie.builder().mno(42L).build();
            Member member = Member.builder().memberId("test1").build();
            Reply reply = Reply.builder()
                    .movie(movie)
                    .grade((long) (i/2))
                    .content("reply" + i)
                    .member(member)
                    .build();
            replyRepository.save(reply);
        });
    }


    @Test
    public void getReplyList(){
    }

    @Test
    public void getGrade(){
        System.out.println(replyRepository.getTotalGrade(43L));
    }




}
