package com.example.movie.repositoryTests;

import com.example.movie.repository.PayRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class payRepositoryTests {
    @Autowired
    private PayRepository payRepository;

    @Test
    public void getList(){
        System.out.println(payRepository.findByMemberMemberId("test1"));
    }
}
