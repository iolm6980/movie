package com.example.movie.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MovieDTO {
    private Long mno;
    @NotBlank(message = "영화 이름을 입력해주세요")
    private String name;
    @NotNull(message = "상영시간을 입력해주세요")
    private int time;
    @NotNull(message = "줄거리를 입력해주세요")
    private String summary;
    private Long totalGrade;
    private String path;
    private String imgName;

    public String imageURL() throws UnsupportedEncodingException {
        return URLEncoder.encode(path, "UTF-8");
    }

}
