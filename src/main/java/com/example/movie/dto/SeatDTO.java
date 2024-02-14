package com.example.movie.dto;

import lombok.Builder;
import lombok.Data;
import java.util.*;
@Builder
@Data

public class SeatDTO {
    public List<Integer> seatList;
    public Long mino;
}
