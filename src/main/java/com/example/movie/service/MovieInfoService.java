package com.example.movie.service;

import com.example.movie.dto.MovieDTO;
import com.example.movie.entity.Movie;
import com.example.movie.entity.MovieInfo;

import java.util.*;
public interface MovieInfoService {
    List<MovieDTO> getMovieList(String date);
    List<MovieDTO> getMovie(String date, Long mno);

    default MovieDTO entityToDTO(MovieInfo movieInfo){
        MovieDTO movieDTO = MovieDTO.builder()
                .mno(movieInfo.getMovie().getMno())
                .name(movieInfo.getMovie().getName())
                .date(movieInfo.getDate())
                .place(movieInfo.getPlace())
                .seat(movieInfo.getSeat())
                .time(movieInfo.getTime())
                .totalGrade(movieInfo.getMovie().getTotalGrade())
                .summary(movieInfo.getSummary())
                .imgName(movieInfo.getMovie().getImgName())
                .path(movieInfo.getMovie().getPath())
                .build();
        return movieDTO;
    }
}
