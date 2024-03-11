package com.example.movie.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MemberDTO {
    @Size(min = 5, message = "아이디는 5자리 이상입력해야합니다")
    @Pattern(regexp = "[a-z0-9]*$", message = "아이디 형식이 일치하지 않습니다")
    private String memberId;

    @Size(min = 8, message = "비밀번호는 8자리 이상입력해야합니다")
    private String password;
    private String role;
}
