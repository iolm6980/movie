package com.example.movie.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class MovieInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mino;
    private String date;
    private String place;
    private String seat;
    private String startTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    public void setSeat(String seat){
        this.seat = seat;
    }
}
