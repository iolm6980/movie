package com.example.movie.serviceTests;

import com.example.movie.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class MovieServiceTests {
    @Autowired
    private MovieService movieService;
    @Test
    public void getMovieListTest(){
        System.out.println(movieService.getMovieList("2017-06-18"));
    }

    @Test
    public void getMovieTest(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(date);
        System.out.println(movieService.getMovie(today, "테스트 영화1"));
    }
}
