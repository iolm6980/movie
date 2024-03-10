package com.example.movie.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String reserveSeat;
    @NotNull
    private int totalPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    private MovieInfo movieInfo;
}
