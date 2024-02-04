package com.example.movie.service;

import com.example.movie.dto.PayDTO;
import com.example.movie.repository.PayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayServiceImpl implements PayService{
    private final PayRepository payRepository;

    @Override
    public void register(PayDTO payDTO) {
        payRepository.save(DtoToEntity(payDTO));
    }
}
