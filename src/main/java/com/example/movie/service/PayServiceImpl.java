package com.example.movie.service;

import com.example.movie.dto.PayDTO;
import com.example.movie.repository.PayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PayServiceImpl implements PayService{
    private final PayRepository payRepository;

    @Override
    public void register(PayDTO payDTO) {
        payRepository.save(DtoToEntity(payDTO));
    }

    @Override
    public List<PayDTO> getPayList(String memberId) {
        List<PayDTO> payDTOList = payRepository.findByMemberMemberId(memberId).stream().map(pay -> entityToDto(pay)).collect(Collectors.toList());
        return payDTOList;
    }
}
