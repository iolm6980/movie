package com.example.movie.service;

import com.example.movie.dto.MovieDTO;
import com.example.movie.entity.Member;
import com.example.movie.entity.Movie;

import java.util.*;
public interface MovieService {
    void movieRegister(MovieDTO movieDTO);
    default Movie entityToDTO(MovieDTO movieDTO){
        Movie movie = Movie.builder()
                .name(movieDTO.getName())
                .summary(movieDTO.getSummary())
                .time(movieDTO.getTime())
                .imgName(movieDTO.getImgName())
                .path(movieDTO.getPath())
                .totalGrade(movieDTO.getTotalGrade())
                .build();
        return movie;
    }
}
