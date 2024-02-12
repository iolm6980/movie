package com.example.movie.service;

import com.example.movie.dto.PageResultDTO;
import com.example.movie.dto.ReplyDTO;
import com.example.movie.entity.Member;
import com.example.movie.entity.Movie;
import com.example.movie.entity.Reply;

public interface ReplyService {
    PageResultDTO<ReplyDTO, Object[]> getReplyList(Long mno, int page);
    void ReplyRegister(ReplyDTO replyDTO);
    Long getTotalGrade(Long mno);
    default ReplyDTO entityToDTO(Reply reply){
        ReplyDTO replyDTO = ReplyDTO.builder()
                .rno(reply.getRno())
                .content(reply.getContent())
                .grade(reply.getGrade())
                .build();
        return replyDTO;
    }

    default Reply DtoToEntity(ReplyDTO replyDTO){
        Member member = Member.builder().memberId(replyDTO.getMemberId()).build();
        Movie movie = Movie.builder().mno(replyDTO.getMovieDTO().getMno()).build();
        Reply reply = Reply.builder()
                .rno(replyDTO.getRno())
                .content(replyDTO.getContent())
                .grade(replyDTO.getGrade())
                .member(member)
                .movie(movie)
                .build();
        return reply;
    }
}
