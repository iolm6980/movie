package com.example.movie.dto;

import com.example.movie.entity.Member;
import com.example.movie.entity.Movie;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReplyDTO {
    private Long rno;
    private String content;
    private Long grade;
    private MovieDTO movieDTO;
    private MemberDTO memberDTO;
    private String memberId;
}
