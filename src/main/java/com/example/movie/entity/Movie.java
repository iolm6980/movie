package com.example.movie.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Time;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;
    @NotBlank(message = "영화이름을 입력해주세요")
    private String name;
    @NotNull(message = "상영시간을 입력해주세요")
    private int time;
    @NotNull(message = "줄거리를 입력해주세요")
    private String summary;
    private Long totalGrade;
    @NotNull(message = "이미지 경로가 비어있습니다")
    private String path;
    @NotNull(message = "이미지 이름이 비어있습니다")
    private String imgName;

}
