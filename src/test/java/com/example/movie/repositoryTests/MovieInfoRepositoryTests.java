package com.example.movie.repositoryTests;

import com.example.movie.entity.Movie;
import com.example.movie.entity.MovieInfo;
import com.example.movie.repository.MovieInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        String today = dateFormat.format(date);
        IntStream.rangeClosed(1, 10).forEach(i ->{
            Movie movie = Movie.builder().mno(Long.valueOf(i)).build();
            MovieInfo movieInfo = MovieInfo.builder()
                    .movie(movie)
                    .place( i + "관")
                    .seat("0")
                    .date(today)
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(date);
        System.out.println(movieInfoRepository.findByDateAndMovieMno(today, 1L));
    }
}
