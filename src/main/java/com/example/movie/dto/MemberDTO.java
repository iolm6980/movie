package com.example.movie.dto;

import jakarta.persistence.Entity;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class MemberDTO {
    private String memberId;
    private String password;
    private String role;
}
