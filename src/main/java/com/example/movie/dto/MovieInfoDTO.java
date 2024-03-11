package com.example.movie.dto;

import com.example.movie.entity.Movie;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.*;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MovieInfoDTO {
    private Long mino;
    @NotNull(message = "날짜를 입력해주세요")
    private String date;
    @NotNull(message = "상영관을 입력해주세요")
    private String place;
    private String seat;
    @NotNull(message = "영화 시작시간을 입력해주세요")
    private String startTime;
    private String endTime;
    private MovieDTO movieDTO;
    private int seatCnt;
    private List<Integer> seatList;
    public void setSeatCnt(int seatCnt){
        this.seatCnt = seatCnt;
    }
}
