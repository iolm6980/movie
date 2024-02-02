package com.example.movie.service;

import com.example.movie.dto.MovieDTO;
import com.example.movie.entity.Movie;
import com.example.movie.entity.MovieInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public interface MovieInfoService {
    List<MovieDTO> getMovieList(String date);
    List<MovieDTO> getMovie(String date, Long mno);

    default MovieDTO entityToDTO(MovieInfo movieInfo) throws ParseException {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date endTime = timeFormat.parse(movieInfo.getStartTime());
        endTime.setMinutes(endTime.getMinutes() + movieInfo.getMovie().getTime());
        MovieDTO movieDTO = MovieDTO.builder()
                .mno(movieInfo.getMovie().getMno())
                .name(movieInfo.getMovie().getName())
                .date(movieInfo.getDate())
                .place(movieInfo.getPlace())
                .seat(movieInfo.getSeat())
                .time(movieInfo.getMovie().getTime())
                .startTime(movieInfo.getStartTime())
                .endTime(timeFormat.format(endTime))
                .totalGrade(movieInfo.getMovie().getTotalGrade())
                .summary(movieInfo.getMovie().getSummary())
                .imgName(movieInfo.getMovie().getImgName())
                .path(movieInfo.getMovie().getPath())
                .build();
        return movieDTO;
    }
}
