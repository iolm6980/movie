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
    private final ConvertEnAndDto convertEnAndDto;
    @Override
    public void movieRegister(MovieDTO movieDTO) {
        movieRepository.save(convertEnAndDto.dtoToEntity(movieDTO));
    }

    @Override
    public List<MovieDTO> getMovieList() {
        List<MovieDTO> list = movieRepository.findAll().stream().map(movie -> convertEnAndDto.entityToDTO(movie)).collect(Collectors.toList());
        return list;
    }

    @Override
    public void updateGrade(Long mno, Long totalGrade) {
        movieRepository.updateGrade(mno, totalGrade);
    }
}
