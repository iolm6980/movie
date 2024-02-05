package com.example.movie.controller;

import com.example.movie.dto.PageResultDTO;
import com.example.movie.dto.ReplyDTO;
import com.example.movie.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    @GetMapping(value = "/{mno}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> replyList(@PathVariable Long mno, @RequestParam(defaultValue = "0") int page){
        System.out.println("mno: "+ mno + "page: " + page);
        PageResultDTO result = replyService.getReplyList(mno, page);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping("/register")
    public void replyRegister(@ModelAttribute ReplyDTO replyDTO){
        System.out.println("reply........" + replyDTO);
        replyService.ReplyRegister(replyDTO);
    }

}