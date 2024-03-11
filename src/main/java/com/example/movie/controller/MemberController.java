package com.example.movie.controller;

import com.example.movie.dto.MemberDTO;
import com.example.movie.security.dto.AuthMemberDTO;
import com.example.movie.security.util.JWTUtil;
import com.example.movie.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    private final JWTUtil jwtUtil;

    @GetMapping("/register")
    public void getRegister(@RequestParam(required = false) String error, @RequestParam(required = false) String exception, Model model){
        System.out.println("register.............");
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
    }
    @PostMapping("/register")
    public String register(@Valid MemberDTO memberDTO){
        System.out.println("memberRegister.............................."+ memberDTO);
        if(!memberService.memberRegister(memberDTO)) throw new RuntimeException("등록과정에서 문제가 발생했습니다.");
        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public void login(Model model, @RequestParam(required = false) String error, @RequestParam(required = false) String exception){
        System.out.println("login..............");
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
    }

    @ResponseBody
    @PostMapping("/createJwt")
    public ResponseEntity<?> createJwt(@RequestBody MemberDTO memberDTO) throws Exception {
        if(memberService.checkMember(memberDTO)) return new ResponseEntity<>(jwtUtil.generateToken(memberDTO.getMemberId()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
