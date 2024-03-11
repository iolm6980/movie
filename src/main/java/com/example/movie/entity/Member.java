package com.example.movie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Member {
    @Id
    @Size(min = 5, message = "아이디는 5자리 이상입력해야합니다")
    @Pattern(regexp = "[a-z0-9]*$", message = "아이디 형식이 일치하지 않습니다")
    private String memberId;

    @Size(min = 8, message = "비밀번호는 8자리 이상입력해야합니다")
    private String password;
    private String role;
}
