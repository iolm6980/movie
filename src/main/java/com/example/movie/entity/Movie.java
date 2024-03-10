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
    @NotBlank
    private String name;
    @NotNull
    private int time;
    @NotNull
    private String summary;
    private Long totalGrade;
    @NotNull
    private String path;
    @NotNull
    private String imgName;

}
