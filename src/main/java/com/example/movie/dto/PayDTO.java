package com.example.movie.dto;

import com.example.movie.entity.Member;
import com.example.movie.entity.MovieInfo;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import java.util.*;
@Data
@Builder
public class PayDTO {

    private String pid;
    private String reserveSeat;
    private int totalPrice;
    private MemberDTO memberDTO;
    private MovieInfoDTO movieInfoDTO;
    private List<Integer> seatList;
}
