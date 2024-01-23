package com.example.movie.entity;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String content;
    private Long grade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie Movie;
    @OneToOne(fetch = FetchType.LAZY)
    private Member member;
}

