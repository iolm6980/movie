package com.example.movie.service;

import com.example.movie.dto.PageResultDTO;
import com.example.movie.dto.ReplyDTO;
import com.example.movie.entity.Reply;

public interface ReplyService {
    public PageResultDTO<ReplyDTO, Object[]> getReplyList(Long mno, int page);

    default ReplyDTO entityToDTO(Reply reply){
        ReplyDTO replyDTO = ReplyDTO.builder()
                .rno(reply.getRno())
                .content(reply.getContent())
                .grade(reply.getGrade())
                .build();
        return replyDTO;
    }
}
