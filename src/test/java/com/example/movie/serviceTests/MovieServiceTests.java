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
//    @Test
//    public void getMovieListTest(){
//    }
//
//    @Test
//    public void getMovieTest(){
//        Date date = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String today = dateFormat.format(date);
//    }
//
//    @Test
//    public void updateGrade(){
//        movieService.updateGrade(29L, 100L);
//    }
}
