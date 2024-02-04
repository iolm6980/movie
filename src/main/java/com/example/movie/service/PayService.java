package com.example.movie.service;

import com.example.movie.dto.PayDTO;
import com.example.movie.entity.Pay;

public interface PayService {
    void register(PayDTO payDTO);

    default Pay DtoToEntity(PayDTO payDTO){
        Pay pay = Pay.builder()
                .pid(payDTO.getPid())
                .reserveSeat(payDTO.getReserveSeat())
                .totalPrice(payDTO.getTotalPrice())
                .member(payDTO.getMember())
                .movieInfo(payDTO.getMovieInfo())
                .build();
        return pay;
    }
}
