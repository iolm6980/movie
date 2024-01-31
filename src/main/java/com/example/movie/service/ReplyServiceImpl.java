package com.example.movie.service;

import com.example.movie.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl {
    private final ReplyRepository replyRepository;
}
