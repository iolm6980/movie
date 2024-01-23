package com.example.movie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String time;
    private String day;
    private String place;
    private String seat;
    private String summary;
    private String path;
    private String imgName;
}
