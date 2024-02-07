package com.example.movie.controller;

import com.example.movie.dto.MemberDTO;
import com.example.movie.security.dto.AuthMemberDTO;
import com.example.movie.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/register")
    public void getRegister(){
        System.out.println("register.............");
    }
    @ResponseBody
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody MemberDTO memberDTO){
        System.out.println("memberRegister.............................."+ memberDTO);

        if(memberService.memberRegister(memberDTO)) return new ResponseEntity<>("회원가입성공", HttpStatus.OK);
        return new ResponseEntity<>("해당 아이디가 이미 존재합니다", HttpStatus.BAD_REQUEST);


    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(required = false) String error, @RequestParam(required = false) String exception){
        System.out.println("login..............");
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "/member/login";
    }

}
