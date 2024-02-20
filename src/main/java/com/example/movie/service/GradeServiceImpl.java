package com.example.movie.service;

import com.example.movie.dto.ReplyDTO;
import com.example.movie.repository.MovieRepository;
import com.example.movie.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
    private final ReplyRepository replyRepository;
    private final MovieRepository movieRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMovieGrade(ReplyDTO replyDTO) {
        Long totalGrade = replyRepository.getTotalGrade(replyDTO.getMovieDTO().getMno());
        movieRepository.updateGrade(replyDTO.getMovieDTO().getMno(), totalGrade);
    }
}
