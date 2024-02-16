package com.example.movie.service;

import com.example.movie.dto.CancelDTO;
import com.example.movie.dto.MovieInfoDTO;
import com.example.movie.dto.PayDTO;
import java.util.*;
public interface SeatService {
    void register(PayDTO payDTO);
    void movieCancel(CancelDTO cancelDTO, List<Integer> seatList);
    void infoModify(MovieInfoDTO movieInfoDTO);
}
