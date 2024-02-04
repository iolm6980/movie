package com.example.movie.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@ToString
public class Pay {
    @Id
    private String pid;
    private String reserveSeat;
    private int totalPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    private MovieInfo movieInfo;
}
