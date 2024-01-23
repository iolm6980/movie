package com.example.movie.repositoryTests;

import com.example.movie.entity.Movie;
import com.example.movie.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MovieRepositoryTests {
    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void movieInsertTest(){
        IntStream.rangeClosed(1, 10).forEach(i ->{
            Movie movie = Movie.builder()
                    .name("테스트 영화" + i)
                    .place( i + "관")
                    .summary("줄거리" + i)
                    .build();
            movieRepository.save(movie);
        });

    }
}
