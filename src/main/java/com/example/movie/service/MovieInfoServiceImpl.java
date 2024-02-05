package com.example.movie.service;

import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.MovieInfoDTO;
import com.example.movie.entity.MovieInfo;
import com.example.movie.repository.MovieInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieInfoServiceImpl implements MovieInfoService{
    private final MovieInfoRepository movieInfoRepository;

    @Override
    public List<MovieInfoDTO> getMovieList(String date) {
        List<MovieInfoDTO> dtoList = movieInfoRepository.findByDate(date).stream()
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
    public List<MovieInfoDTO> getMovie(String date, Long mno) {
        List<MovieInfoDTO> dtoList = movieInfoRepository.findByDateAndMovieMno(date, mno).stream()
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
    public void seatRegister(List<Integer> indexList, Long mino) {
        Optional<MovieInfo> movieInfo = movieInfoRepository.findById(mino);
        if(movieInfo.isPresent()) {
            MovieInfo result = movieInfo.get();
            StringBuilder sb = new StringBuilder(result.getSeat());
            indexList.forEach(i -> sb.setCharAt(i-1, '1'));
            result.changeSeat(String.valueOf(sb));
            movieInfoRepository.save(result);
        }
    }
}
