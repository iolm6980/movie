package com.example.movie.entity;

import jakarta.persistence.*;
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
    private String name;
    private int time;
    private String summary;
    private Long totalGrade;

    private String path;
    private String imgName;

}
