package com.example.movie.controller;

import com.example.movie.dto.PayDTO;
import com.example.movie.security.dto.AuthMemberDTO;
import com.example.movie.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pay")
public class PayController {
    private final PayService payService;
    @ResponseBody
    @PostMapping("/register")
    void payRegister(@RequestBody PayDTO payDTO){
        System.out.println("pay........." + payDTO);
        payService.register(payDTO);
    }

    @GetMapping("/list")
    void payList(Model model, @AuthenticationPrincipal AuthMemberDTO authMemberDTO){
        model.addAttribute("payDTOList", payService.getPayList(authMemberDTO.getUsername()));
    }
}
