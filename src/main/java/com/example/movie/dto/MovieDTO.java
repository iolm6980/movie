package com.example.movie.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDTO {
    private Long mno;
    private String name;
    private int time;
    private String summary;
    private Long totalGrade;
    private String path;
    private String imgName;
}
