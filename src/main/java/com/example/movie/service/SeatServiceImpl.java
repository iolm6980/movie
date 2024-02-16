package com.example.movie.service;

import com.example.movie.dto.CancelDTO;
import com.example.movie.dto.MovieInfoDTO;
import com.example.movie.dto.PayDTO;
import com.example.movie.entity.MovieInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void movieCancel(CancelDTO cancelDTO, List<Integer> seatList) {
        payService.deletePay(cancelDTO.getPayDTO().getPid());
        movieInfoService.seatUpdate(seatList,cancelDTO.getPayDTO().getMovieInfoDTO().getMino());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void infoModify(MovieInfoDTO movieInfoDTO) {
        movieInfoService.infoModify(movieInfoDTO);
        movieInfoService.seatUpdate(movieInfoDTO.getSeatList(),movieInfoDTO.getMino());
    }


}
