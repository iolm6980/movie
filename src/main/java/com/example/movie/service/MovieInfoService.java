package com.example.movie.service;

import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.MovieInfoDTO;
import com.example.movie.entity.Movie;
import com.example.movie.entity.MovieInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public interface MovieInfoService {
    List<MovieInfoDTO> getMovieList(String date);
    List<MovieInfoDTO> getMovie(String date, Long mno);
    void seatUpdate(List<Integer> indexList, Long mino);
    void infoRegister(List<MovieInfoDTO> movieInfoDTOList);

    default MovieInfoDTO entityToDTO(MovieInfo movieInfo) throws ParseException {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date endTime = timeFormat.parse(movieInfo.getStartTime());
        endTime.setMinutes(endTime.getMinutes() + movieInfo.getMovie().getTime());
        MovieDTO movieDTO = MovieDTO.builder()
                .mno(movieInfo.getMovie().getMno())
                .name(movieInfo.getMovie().getName())
                .totalGrade(movieInfo.getMovie().getTotalGrade())
                .summary(movieInfo.getMovie().getSummary())
                .time(movieInfo.getMovie().getTime())
                .path(movieInfo.getMovie().getPath())
                .imgName(movieInfo.getMovie().getImgName())
                .build();

        MovieInfoDTO movieInfoDTO = MovieInfoDTO.builder()
                .mino(movieInfo.getMino())
                .date(movieInfo.getDate())
                .place(movieInfo.getPlace())
                .seat(movieInfo.getSeat())
                .startTime(movieInfo.getStartTime())
                .endTime(timeFormat.format(endTime))
                .movieDTO(movieDTO)
                .build();
        return movieInfoDTO;
    }

    default MovieInfo dtoToEntity(MovieInfoDTO movieInfoDTO){
        MovieInfo movieInfo = MovieInfo.builder()
                .mino(movieInfoDTO.getMino())
                .date(movieInfoDTO.getDate())
                .place(movieInfoDTO.getPlace())
                .seat("0".repeat(72))
                .startTime(movieInfoDTO.getStartTime())
                .movie(dtoToEntity(movieInfoDTO.getMovieDTO()))
                .build();
        return movieInfo;
    }

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
}
