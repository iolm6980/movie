package com.example.movie.controller;

import com.example.movie.dto.PageResultDTO;
import com.example.movie.dto.ReplyDTO;
import com.example.movie.service.GradeService;
import com.example.movie.service.ReplyService;
import com.nimbusds.jose.Header;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;
    private final GradeService gradeService;
    @GetMapping(value = "/{mno}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> replyList(@PathVariable Long mno, @RequestParam(defaultValue = "0") int page){

        System.out.println("mno: "+ mno + "page: " + page);
        PageResultDTO result = replyService.getReplyList(mno, page);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<?> replyRegister(@RequestBody @Valid ReplyDTO replyDTO){
        System.out.println("reply........" + replyDTO);
        gradeService.updateMovieGrade(replyDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
