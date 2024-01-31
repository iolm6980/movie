package com.example.movie.service;

import com.example.movie.dto.MovieDTO;
import com.example.movie.entity.Movie;
import com.example.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public List<MovieDTO> getMovieList(String date) {
//        List<MovieDTO> dtoList = movieRepository.findByDate(date).stream().map(movie -> entityToDTO(movie)).collect(Collectors.toList());
//        return dtoList;
        return null;
    }

    @Override
    public List<MovieDTO> getMovie(String date, String name) {
//        List<MovieDTO> dtoList = movieRepository.findByDateAndName(date, name).stream().map(movie -> entityToDTO(movie)).collect(Collectors.toList());
//        return dtoList;
        return null;
    }
}
