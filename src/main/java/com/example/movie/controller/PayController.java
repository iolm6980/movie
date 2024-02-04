package com.example.movie.controller;

import com.example.movie.dto.PayDTO;
import com.example.movie.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pay")
public class PayController {
    private final PayService payService;
    @PostMapping("/register")
    void payRegister(@RequestBody PayDTO payDTO){
        System.out.println("pay........." + payDTO);
        payService.register(payDTO);
    }
}
