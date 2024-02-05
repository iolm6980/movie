package com.example.movie.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDTO {
    private Long mno;
    private Long mino;
    private String name;
    private int time;
    private String date;
    private String startTime;
    private String endTime;
    private String place;
    private String seat;
    private String summary;
    private String path;
    private String imgName;
    private int seatCnt;
    private Long totalGrade;
}
