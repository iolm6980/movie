package com.example.movie.service;

import com.example.movie.dto.MovieDTO;
import com.example.movie.entity.Member;
import com.example.movie.entity.Movie;

import java.util.*;
public interface MovieService {
    void movieRegister(MovieDTO movieDTO);
    List<MovieDTO> getMovieList();
    default Movie dtoToEntity(MovieDTO movieDTO){
        Movie movie = Movie.builder()
                .mno(movieDTO.getMno())
                .name(movieDTO.getName())
                .summary(movieDTO.getSummary())
                .time(movieDTO.getTime())
                .imgName(movieDTO.getImgName())
                .path(movieDTO.getPath())
                .totalGrade(movieDTO.getTotalGrade())
                .build();
        return movie;
    }

    default MovieDTO entityToDTO(Movie movie){
        MovieDTO movieDTO = MovieDTO.builder()
                .mno(movie.getMno())
                .imgName(movie.getImgName())
                .time(movie.getTime())
                .name(movie.getName())
                .summary(movie.getSummary())
                .totalGrade(movie.getTotalGrade())
                .path(movie.getPath())
                .build();
        return movieDTO;
    }
}
