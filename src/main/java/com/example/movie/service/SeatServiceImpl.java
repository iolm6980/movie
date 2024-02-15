package com.example.movie.service;

import com.example.movie.dto.PayDTO;
import com.example.movie.entity.MovieInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService{
    private final PayService payService;
    private final MovieInfoService movieInfoService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(PayDTO payDTO) {
        payService.register(payDTO);
        movieInfoService.seatUpdate(payDTO.getSeatList(), payDTO.getMovieInfoDTO().getMino());
    }
}
