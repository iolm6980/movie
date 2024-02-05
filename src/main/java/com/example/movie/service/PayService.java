package com.example.movie.service;

import com.example.movie.dto.PayDTO;
import com.example.movie.entity.Member;
import com.example.movie.entity.MovieInfo;
import com.example.movie.entity.Pay;

public interface PayService {
    void register(PayDTO payDTO);

    default Pay DtoToEntity(PayDTO payDTO){
        Member member = Member.builder().memberId(payDTO.getMemberDTO().getMemberId()).build();
        MovieInfo movieInfo = MovieInfo.builder().mino(payDTO.getMovieInfoDTO().getMino()).build();
        Pay pay = Pay.builder()
                .pid(payDTO.getPid())
                .reserveSeat(payDTO.getReserveSeat())
                .totalPrice(payDTO.getTotalPrice())
                .member(member)
                .movieInfo(movieInfo)
                .build();
        return pay;
    }
}
