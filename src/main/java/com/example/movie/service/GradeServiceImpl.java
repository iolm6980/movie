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
    private final ReplyService replyService;
    private final MovieService movieService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMovieGrade(ReplyDTO replyDTO) {
        replyService.ReplyRegister(replyDTO);
        Long totalGrade = replyService.getTotalGrade(replyDTO.getMovieDTO().getMno());
        movieService.updateGrade(replyDTO.getMovieDTO().getMno(), totalGrade);
    }
}
