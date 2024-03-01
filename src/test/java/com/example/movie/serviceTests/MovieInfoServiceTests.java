package com.example.movie.serviceTests;

import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.MovieInfoDTO;
import com.example.movie.entity.MovieInfo;
import com.example.movie.repository.MovieInfoRepository;
import com.example.movie.service.MovieInfoService;
import com.example.movie.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
@SpringBootTest
public class MovieInfoServiceTests {
    @Autowired
    private MovieInfoService movieInfoService;
//    @Test
//    public void getMovieListTest(){
//        Date date = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String today = dateFormat.format(date);
//        System.out.println(movieInfoService.getMovieList(today));
//    }
//
//    @Test
//    public void getMovieTest(){
//        Date date = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String today = dateFormat.format(date);
//        List<MovieInfoDTO> list = movieInfoService.getMovie(today, 1L);
//        System.out.println(list);
//    }
}
