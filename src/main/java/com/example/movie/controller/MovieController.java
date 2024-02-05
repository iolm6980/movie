package com.example.movie.controller;

import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.MovieInfoDTO;
import com.example.movie.service.MovieInfoService;
import com.example.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieInfoService movieInfoService;
    @GetMapping("/test")
    public void test() {

    }

    @GetMapping("/list")
    public void list(@RequestParam(required = false) String date, Model model){
        if(date == null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date today = new Date();
            date = dateFormat.format(today);
        }
        model.addAttribute("movieInfoList", movieInfoService.getMovieList(date));
    }

    @GetMapping("/detail")
    public void detail(String date, Long mno, Model model){
        System.out.println("date: " + date + " name: " + mno);
        List<MovieInfoDTO> movieDTOList = movieInfoService.getMovie(date, mno);
        movieDTOList.forEach(movieInfoDTO ->{
            int cnt = 0;
            for(int i=0; i<movieInfoDTO.getSeat().length(); i++)
                if(movieInfoDTO.getSeat().charAt(i) == '0') cnt++;
            movieInfoDTO.setSeatCnt(cnt);
        });
        model.addAttribute("movieInfoList", movieDTOList);
    }

    @PostMapping("/seat")
    public String seatRegister(@RequestParam List<Integer> index, Long mino){
        movieInfoService.seatRegister(index, mino);
        return "redirect:/movie/list";
    }
}
