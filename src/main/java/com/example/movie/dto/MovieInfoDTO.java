package com.example.movie.dto;

import com.example.movie.entity.Movie;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieInfoDTO {
    private Long mino;;
    private String date;
    private String place;
    private String seat;
    private String startTime;
    private String endTime;
    private MovieDTO movieDTO;
    private int seatCnt;
}
