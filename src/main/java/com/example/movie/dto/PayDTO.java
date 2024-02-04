package com.example.movie.dto;

import com.example.movie.entity.Member;
import com.example.movie.entity.MovieInfo;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class PayDTO {

    private String pid;
    private String reserveSeat;
    private int totalPrice;
    private Member member;
    private MovieInfo movieInfo;
}
