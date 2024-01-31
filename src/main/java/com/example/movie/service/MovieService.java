package com.example.movie.service;

import com.example.movie.dto.MovieDTO;
import com.example.movie.entity.Movie;

import java.util.*;
public interface MovieService {
    List<MovieDTO> getMovieList(String date);
    List<MovieDTO> getMovie(String date, String name);


    default MovieDTO entityToDTO(Movie movie){
        MovieDTO movieDTO = MovieDTO.builder()
//                .mno(movieInfo.getMno())
//                .name(movieInfo.getName())
//                .date(movieInfo.getDate())
//                .place(movieInfo.getPlace())
//                .seat(movieInfo.getSeat())
//                .time(movieInfo.getTime())
//                .totalGrade(movieInfo.getTotalGrade())
//                .summary(movieInfo.getSummary())
//                .imgName(movieInfo.getImgName())
//                .path(movieInfo.getPath())
                .build();
        return movieDTO;
    }
}
