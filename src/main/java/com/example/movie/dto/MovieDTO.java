package com.example.movie.dto;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MovieDTO {
    private Long mno;
    private String name;
    private int time;
    private String summary;
    private Long totalGrade;
    private String path;
    private String imgName;

    public String imageURL() throws UnsupportedEncodingException {
        return URLEncoder.encode(path, "UTF-8");
    }

    public void setImgName(String imgName){
        this.imgName = imgName;
    }

    public void setPath(String path){
        this.path = path;
    }
}
