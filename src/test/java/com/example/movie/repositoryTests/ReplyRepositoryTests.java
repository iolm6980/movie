package com.example.movie.repositoryTests;

import com.example.movie.entity.Member;
import com.example.movie.entity.Movie;
import com.example.movie.entity.Reply;
import com.example.movie.repository.MovieRepository;
import com.example.movie.repository.ReplyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void ReplyInsertTest(){
        IntStream.rangeClosed(1, 10).forEach(i ->{
            Movie movie = Movie.builder().mno((long)i).build();
            Member member = Member.builder().memberId("test"+i).build();
            Reply reply = Reply.builder()
                    .Movie(movie)
                    .content("reply" + i)
                    .member(member)
                    .build();
            replyRepository.save(reply);
        });
    }
}
