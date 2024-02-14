package com.example.movie.repositoryTests;

import com.example.movie.repository.PayRepository;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class payRepositoryTests {
    @Autowired
    private PayRepository payRepository;
    @Test
    public void getList(){
        List<Object[]> list = payRepository.getPayList("test1");

        for(Object[] objects : list){
            System.out.println(Arrays.toString(objects));
        }
    }

    @Test
    public void tokenTest() throws IamportResponseException, IOException {
        IamportClient iamportClient = new IamportClient("11111", "55555");
        System.out.println(iamportClient.paymentByImpUid("26634d49-a35f-46cf-aea4-fe7f4ba6be2d"));
    }

    @Test
    public void delete(){
        payRepository.deleteById("26634d49-a35f-46cf-aea4-fe7f4ba6be2d");
    }
}
