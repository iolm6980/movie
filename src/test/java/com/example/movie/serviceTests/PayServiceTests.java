package com.example.movie.serviceTests;

import com.example.movie.service.PayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class PayServiceTests {
    @Autowired
    private PayService payService;
    @Value("${apiKey}")
    private String apikey;
    @Value("${secretKey}")
    private String secretKey;

    @Test
    public void getPayList() throws IOException {
        String token = payService.getToken(apikey, secretKey);
        payService.refundRequest(token, "0b5f32fb-bd6c-4207-91e7-911eb3c044fc", "취소");
    }
}
