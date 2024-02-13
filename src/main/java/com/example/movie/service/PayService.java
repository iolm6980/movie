package com.example.movie.service;

import com.example.movie.dto.MemberDTO;
import com.example.movie.dto.MovieInfoDTO;
import com.example.movie.dto.PayDTO;
import com.example.movie.entity.Member;
import com.example.movie.entity.MovieInfo;
import com.example.movie.entity.Pay;
import java.util.*;
public interface PayService {
    void register(PayDTO payDTO);
    List<PayDTO> getPayList(String memberId);

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

    default PayDTO entityToDto(Pay pay){
        MemberDTO memberDTO = MemberDTO.builder().memberId(pay.getMember().getMemberId()).build();
        MovieInfoDTO movieInfoDTO = MovieInfoDTO.builder().mino(pay.getMovieInfo().getMino()).build();
        PayDTO payDTO = PayDTO.builder()
                .pid(pay.getPid())
                .reserveSeat(pay.getReserveSeat())
                .totalPrice(pay.getTotalPrice())
                .memberDTO(memberDTO)
                .movieInfoDTO(movieInfoDTO)
                .build();
        return payDTO;
    }
}
