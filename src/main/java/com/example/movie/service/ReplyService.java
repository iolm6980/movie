package com.example.movie.service;

import com.example.movie.dto.PageResultDTO;
import com.example.movie.dto.ReplyDTO;
import com.example.movie.entity.Reply;

public interface ReplyService {
    PageResultDTO<ReplyDTO, Object[]> getReplyList(Long mno, int page);
    void ReplyRegister(ReplyDTO replyDTO);
    default ReplyDTO entityToDTO(Reply reply){
        ReplyDTO replyDTO = ReplyDTO.builder()
                .rno(reply.getRno())
                .content(reply.getContent())
                .grade(reply.getGrade())
                .build();
        return replyDTO;
    }

    default Reply DtoToEntity(ReplyDTO replyDTO){
        Reply reply = Reply.builder()
                .rno(replyDTO.getRno())
                .content(replyDTO.getContent())
                .grade(replyDTO.getGrade())
                .member(replyDTO.getMember())
                .movie(replyDTO.getMovie())
                .build();
        return reply;
    }
}