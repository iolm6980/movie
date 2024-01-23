package com.example.movie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Member {
    @Id
    private String memberId;
    private String password;
    private String ticket;
}
