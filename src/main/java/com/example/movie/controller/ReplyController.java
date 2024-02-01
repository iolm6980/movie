package com.example.movie.controller;

import com.example.movie.dto.PageResultDTO;
import com.example.movie.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/{mno}")
    public ResponseEntity<?> ReplyList(@PathVariable Long mno, @RequestParam int page){
        System.out.println("mno: "+ mno + "page: " + page);
        PageResultDTO result = replyService.getReplyList(mno, page);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
