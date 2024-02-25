package com.example.movie.controller;

import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.MovieInfoDTO;
import com.example.movie.security.dto.AuthMemberDTO;
import com.example.movie.service.MovieInfoService;
import com.example.movie.service.MovieService;
import com.example.movie.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
@Transactional(rollbackFor = Exception.class)
public class MovieController {
    private final MovieInfoService movieInfoService;
    private final MovieService movieService;
    private final SeatService seatService;
    @Value("${com.example.upload.path}")
    private String uploadPath;
    @PostMapping("/test")
    public void test() {
        System.out.println("test.......................");
    }

    @GetMapping("/list")
    public void list(@RequestParam(required = false) String date, Model model, @AuthenticationPrincipal AuthMemberDTO authMemberDTO) throws ParseException {
        System.out.println("auth..........." + authMemberDTO);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(date == null) {
            Date today = new Date();
            //date = dateFormat.format(today);
            date = "2024-02-19";
        }else {
            Date dat = dateFormat.parse(date);
            date = dateFormat.format(dat);
        }
        model.addAttribute("movieInfoList", movieInfoService.getMovieList(date));
        model.addAttribute("auth", authMemberDTO);
    }

    @GetMapping("/detail")
    public void detail(String date, Long mno, Model model, @AuthenticationPrincipal AuthMemberDTO authMemberDTO){
        System.out.println("date: " + date + " name: " + mno);
        System.out.println("authMemberDTO: " + authMemberDTO.getAuthorities());
        List<MovieInfoDTO> movieDTOList = movieInfoService.getMovie(date, mno);
        movieDTOList.forEach(movieInfoDTO ->{
            int cnt = 0;
            for(int i=0; i<movieInfoDTO.getSeat().length(); i++)
                if(movieInfoDTO.getSeat().charAt(i) == '0') cnt++;
            movieInfoDTO.setSeatCnt(cnt);
        });
        model.addAttribute("movieInfoList", movieDTOList);
        model.addAttribute("auth", authMemberDTO);
    }

    @PostMapping("/seat")
    public String seatUpdate(@RequestParam List<Integer> index, Long mino){
        System.out.println("seatUpdate..........." + index);
        movieInfoService.seatUpdate(index, mino);
        return "redirect:/movie/list";
    }


    @GetMapping("/movieRegister")
    public void getMovieRegister(Model model, @AuthenticationPrincipal AuthMemberDTO authMemberDTO){
        model.addAttribute("auth", authMemberDTO);
    }

    @PostMapping("/movieRegister")
    public String postMovieRegister(@RequestParam MultipartFile file, MovieDTO movieDTO) throws IOException {
        String originalName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath + File.separator + uuid + "_" + originalName;

        Path savePath = Paths.get(saveName);

        file.transferTo(savePath);
        movieDTO.setImgName(originalName);
        movieDTO.setPath(savePath.toString());
        System.out.println("movieRegister.........." + movieDTO);
        movieService.movieRegister(movieDTO);
        return "redirect:/movie/movieRegister";
    }

    @GetMapping("/infoRegister")
    public void getInfoRegister(Model model, @AuthenticationPrincipal AuthMemberDTO authMemberDTO){
        List<MovieDTO> movieDTOList = movieService.getMovieList();
        List<MovieInfoDTO> movieInfoDTOList = movieInfoService.getMovieList("2024-02-08");
        model.addAttribute("movieDTOList", movieDTOList);
        model.addAttribute("movieInfoDTOList", movieInfoDTOList);
        model.addAttribute("auth", authMemberDTO);
    }
    @ResponseBody
    @PostMapping("/infoRegister")
    public ResponseEntity<?> postInfoRegister(@RequestBody List<MovieInfoDTO> movieInfoDTOList){
        System.out.println("infoRegister............" + movieInfoDTOList);
        movieInfoService.infoRegister(movieInfoDTOList);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @ResponseBody
    @PostMapping("/updateGrade")
    public void updateGrade(Long totalGrade, Long mno){
        System.out.println("updateGrade........" + totalGrade + " mno: " + mno);
        movieService.updateGrade(totalGrade, mno);
    }

    @ResponseBody
    @PostMapping("/infoModify")
    public ResponseEntity<?> postInfoModify(@RequestBody MovieInfoDTO movieInfoDTO){
        System.out.println("infoModify............" + movieInfoDTO);
        seatService.infoModify(movieInfoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/testPut")
    public void testPut(MovieDTO movieDTO){
        System.out.println("테스트2............");
        movieService.movieRegister(movieDTO);
    }
    @PostMapping("/testPost")
    public void testPost(MovieDTO movieDTO){
        System.out.println("테스트1............");
        movieService.movieRegister(movieDTO);
    }

}
