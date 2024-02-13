package com.example.movie.repositoryTests;

import com.example.movie.entity.Movie;
import com.example.movie.entity.MovieInfo;
import com.example.movie.repository.MovieInfoRepository;
import com.example.movie.security.dto.AuthMemberDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.IntStream;

@SpringBootTest
public class MovieInfoRepositoryTests {
    @Autowired
    private MovieInfoRepository movieInfoRepository;

    @Test
    public void insertTest(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String today = dateFormat.format(date);
        String seat = "0".repeat(72);
        IntStream.rangeClosed(1, 10).forEach(i ->{
            Movie movie = Movie.builder().mno(Long.valueOf(i)).build();
            MovieInfo movieInfo = MovieInfo.builder()
                    .movie(movie)
                    .place( i + "관")
                    .seat(seat)
                    .date(today)
                    .startTime(timeFormat.format(date))
                    .build();
            movieInfoRepository.save(movieInfo);
        });
    }

    @Test
    public void getMovieList(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(date);
        System.out.println(movieInfoRepository.findByDate(today));
    }

    @Test
    public void getMovie(){
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(date);
        System.out.println(movieInfoRepository.findByDateAndMovieMno(today, 1L));
    }
    @Test
    public void getMovieInfoList(){
        System.out.println(movieInfoRepository.findByMovieMno(44L));
    }
    @Test
    public void test(){

    }

}
