package com.example.movie.service;

import com.example.movie.dto.MovieDTO;
import com.example.movie.entity.MovieInfo;
import com.example.movie.repository.MovieInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieInfoServiceImpl implements MovieInfoService{
    private final MovieInfoRepository movieInfoRepository;

    @Override
    public List<MovieDTO> getMovieList(String date) {
        List<MovieDTO> dtoList = movieInfoRepository.findByDate(date).stream()
                .map(movie -> {
                    try {
                        return entityToDTO(movie);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public List<MovieDTO> getMovie(String date, Long mno) {
        List<MovieDTO> dtoList = movieInfoRepository.findByDateAndMovieMno(date, mno).stream()
                .map(movie -> {
                    try {
                        return entityToDTO(movie);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());
        return dtoList;
    }
}
