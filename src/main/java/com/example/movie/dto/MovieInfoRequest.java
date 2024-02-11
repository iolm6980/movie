package com.example.movie.dto;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieInfoRequest {
    private List<MovieInfoDTO> movieInfoDTOList;
}
