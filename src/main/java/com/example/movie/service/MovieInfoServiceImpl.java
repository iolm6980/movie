package com.example.movie.service;

import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.MovieInfoDTO;
import com.example.movie.entity.MovieInfo;
import com.example.movie.repository.MovieInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class MovieInfoServiceImpl implements MovieInfoService, ConvertService{
    private final MovieInfoRepository movieInfoRepository;
    //private final ConvertEnAndDto convertEnAndDto;
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
    public void seatUpdate(List<Integer> indexList, Long mino) {
        log.info("test ...." +indexList);
        Optional<MovieInfo> movieInfo = movieInfoRepository.findById(mino);
        if(movieInfo.isPresent()) {
            MovieInfo result = movieInfo.get();
            StringBuilder sb = new StringBuilder(result.getSeat());
            indexList.forEach(i -> {
                if(sb.charAt(i-1) == '1') sb.setCharAt(i-1, '0');
                else sb.setCharAt(i-1, '1');
            });
            result.setSeat(String.valueOf(sb));
            movieInfoRepository.save(result);
        }
    }

    @Override
    public void infoRegister(List<MovieInfoDTO> movieInfoDTOList) {
        List<MovieInfo> list = movieInfoDTOList.stream().map(movieInfo -> dtoToEntity(movieInfo)).collect(Collectors.toList());
        movieInfoRepository.saveAll(list);
    }

    @Override
    public List<MovieInfoDTO> getMovieInfoList(Long mno) {
        List<MovieInfoDTO> movieInfoDTOList = movieInfoRepository.findByMovieMno(mno).stream().map(movieInfo -> {
            try {
                return entityToDTO(movieInfo);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
        return movieInfoDTOList;
    }

    @Override
    public void infoModify(MovieInfoDTO movieInfoDTO) {
        MovieInfo movieInfo = dtoToEntity(movieInfoDTO);
        movieInfoRepository.save(movieInfo);
    }

}
