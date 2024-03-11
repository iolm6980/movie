package com.example.movie.dto;

import com.example.movie.entity.Member;
import com.example.movie.entity.Movie;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReplyDTO {
    private Long rno;
    @NotBlank(message = "감상평을 작성해주세요")
    private String content;
    @NotNull
    private Long grade;
    private MovieDTO movieDTO;
    private MemberDTO memberDTO;
    private String memberId;
}
