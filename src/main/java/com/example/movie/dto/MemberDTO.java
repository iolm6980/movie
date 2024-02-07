package com.example.movie.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDTO {
    private String memberId;
    private String password;
    private String role;
}
