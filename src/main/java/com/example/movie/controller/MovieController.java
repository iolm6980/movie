package com.example.movie.controller;

import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.MovieInfoDTO;
import com.example.movie.security.dto.AuthMemberDTO;
import com.example.movie.security.util.JWTUtil;
import com.example.movie.service.MovieInfoService;
import com.example.movie.service.MovieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieInfoService movieInfoService;
    private final MovieService movieService;

    @Value("${com.example.upload.path}")
    private String uploadPath;
    @GetMapping("/test")
    public void test() {

    }

    @GetMapping("/list")
    public void list(@RequestParam(required = false) String date, Model model, @AuthenticationPrincipal AuthMemberDTO authMemberDTO, HttpServletRequest request){
        if(date == null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date today = new Date();
            date = dateFormat.format(today);
        }
        model.addAttribute("movieInfoList", movieInfoService.getMovieList(date));

    }

    @GetMapping("/detail")
    public void detail(String date, Long mno, Model model, @AuthenticationPrincipal AuthMemberDTO authMemberDTO){
        System.out.println("date: " + date + " name: " + mno);
        System.out.println("authMemberDTO: " + authMemberDTO);
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


    @GetMapping("/movieRegister")
    public void getMovieRegister(){

    }

    @PostMapping("/movieRegister")
    public void postMovieRegister(@RequestParam MultipartFile file, MovieDTO movieDTO) throws IOException {

        String originalName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath + File.separator + uuid + "_" + originalName;

        Path savePath = Paths.get(saveName);

        file.transferTo(savePath);
        movieDTO.setImgName(originalName);
        movieDTO.setPath(savePath.toString());
        System.out.println("movieRegister.........." + movieDTO);
        movieService.movieRegister(movieDTO);

    }
}
