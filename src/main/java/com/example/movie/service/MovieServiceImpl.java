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
    public void movieRegister(MovieDTO movieDTO) {
        movieRepository.save(dtoToEntity(movieDTO));
    }

    @Override
    public List<MovieDTO> getMovieList() {
        List<MovieDTO> list = movieRepository.findAll().stream().map(movie -> entityToDTO(movie)).collect(Collectors.toList());
        return list;
    }

    @Override
    public void updateGrade(Long totalGrade, Long mno) {
        movieRepository.updateGrade(mno, totalGrade);
    }
}
