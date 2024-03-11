package com.example.movie.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "날짜를 입력해주세요")
    private String date;
    @NotNull(message = "상영관를 입력해주세요")
    private String place;
    private String seat;
    @NotNull(message = "영화 시작시간을 입력해주세요")
    private String startTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    public void setSeat(String seat){
        this.seat = seat;
    }
}
