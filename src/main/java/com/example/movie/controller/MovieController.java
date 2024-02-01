package com.example.movie.controller;

import com.example.movie.service.MovieInfoService;
import com.example.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieInfoService movieInfoService;
    @GetMapping("/test")
    public void test(@RequestParam String time) throws ParseException {
        int r = 120;
        SimpleDateFormat simpleFormat = new SimpleDateFormat("HH:mm");
        Date startTime = simpleFormat.parse(time);
        startTime.setMinutes(startTime.getMinutes() + r);
        System.out.println("date............................." + startTime);
    }

    @GetMapping("/list")
    public void list(@RequestParam(required = false) String date, Model model){
        if(date == null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date today = new Date();
            date = dateFormat.format(today);
        }
        model.addAttribute("movieList", movieInfoService.getMovieList(date));
    }

    @GetMapping("/detail")
    public void detail(String date, Long mno, Model model){
        System.out.println("date: " + date + " name: " + mno);
        model.addAttribute("movie", movieInfoService.getMovie(date, mno));
    }
}
