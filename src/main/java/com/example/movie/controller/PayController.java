package com.example.movie.controller;

import com.example.movie.dto.CancelDTO;
import com.example.movie.dto.PayDTO;
import com.example.movie.security.dto.AuthMemberDTO;
import com.example.movie.service.PayService;
import com.example.movie.service.SeatService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.*;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/pay")
public class PayController {
    private final PayService payService;
    private final SeatService seatService;
    @Value("${apiKey}")
    private String apikey;
    @Value("${secretKey}")
    private String secretKey;
    private IamportClient iamportClient = new IamportClient("6118651770772336", "STo8UWUgrU7FU2VtJem75ma1IXW9H3I6me1Y3jDcWvtqoyaRFQrRqAOf6SKxGM1GfFWzCYRVe1u75zNb");
    @ResponseBody
    @PostMapping("/register")
    public void payRegister(@RequestBody PayDTO payDTO){
        System.out.println("pay........." + payDTO);
        seatService.register(payDTO);
        //payService.register(payDTO);
    }

    @GetMapping("/list")
    public void payList(Model model, @AuthenticationPrincipal AuthMemberDTO authMemberDTO){
        model.addAttribute("payDTOList", payService.getPayList(authMemberDTO.getUsername()));
        model.addAttribute("auth", authMemberDTO);
    }
    @ResponseBody
    @PostMapping("/cancel")
    public ResponseEntity<?> payCancel(@RequestBody CancelDTO cancelDTO) throws IOException {
        System.out.println("cancel........" + cancelDTO);

        try{
            String[] seatArr = cancelDTO.getPayDTO().getReserveSeat().split(" ");
            List<Integer> seatList = new ArrayList<>();
            for(String seat: seatArr) seatList.add((seat.charAt(0) - 'A') * 12 + Integer.valueOf(seat.substring(1)));
            String token = payService.getToken(apikey, secretKey);
            payService.refundRequest(token, cancelDTO.getMerchant_uid(), cancelDTO.getReason());
            seatService.movieCancel(cancelDTO, seatList);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            String error = e.getMessage();
            return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
        }
    }


    @ResponseBody
    @PostMapping("/verify/{imp_uid}")
    public IamportResponse<Payment> verifyIamport(@PathVariable String imp_uid) throws IamportResponseException, IOException {
        System.out.println("verify............." + imp_uid);
        return iamportClient.paymentByImpUid(imp_uid);
    }
}
