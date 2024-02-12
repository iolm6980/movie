package com.example.movie.repositoryTests;

import com.example.movie.entity.Movie;
import com.example.movie.entity.MovieInfo;
import com.example.movie.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.IntStream;

@SpringBootTest
public class MovieRepositoryTests {
    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void movieInsertTest(){
        IntStream.rangeClosed(1, 10).forEach(i ->{
            Movie movie = Movie.builder()
                    .name("영화 이름" + i)
                    .time(i*10)
                    .summary("줄거리"+i)
                    .totalGrade(Long.valueOf(i/2)).build();
            movieRepository.save(movie);
        });
    }

    @Test
    public void getMovieList(){
        Pageable p = PageRequest.of(1, 10);
        System.out.println(p.getPageSize());
        int page = 5;
        int tempEnd = (int) (Math.ceil(page/10.0)) * 10;
    }
    @Test
    public void updateGrade(){
        movieRepository.updateGrade(42L, 50L);
    }
}
