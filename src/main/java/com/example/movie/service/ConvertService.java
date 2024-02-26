package com.example.movie.service;

import com.example.movie.dto.*;
import com.example.movie.entity.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface ConvertService {
    default ReplyDTO entityToDTO(Reply reply){
        ReplyDTO replyDTO = ReplyDTO.builder()
                .rno(reply.getRno())
                .content(reply.getContent())
                .grade(reply.getGrade())
                .build();
        return replyDTO;
    }

    default Reply DtoToEntity(ReplyDTO replyDTO){
        Member member = Member.builder().memberId(replyDTO.getMemberDTO().getMemberId()).build();
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

    default Pay DtoToEntity(PayDTO payDTO){
        Member member = Member.builder().memberId(payDTO.getMemberDTO().getMemberId()).build();
        MovieInfo movieInfo = MovieInfo.builder().mino(payDTO.getMovieInfoDTO().getMino()).build();
        Pay pay = Pay.builder()
                .pid(payDTO.getPid())
                .reserveSeat(payDTO.getReserveSeat())
                .totalPrice(payDTO.getTotalPrice())
                .member(member)
                .movieInfo(movieInfo)
                .build();
        return pay;
    }

    default PayDTO entityToDto(Pay pay, Member member, MovieInfo movieInfo, Movie movie) throws ParseException {
        MemberDTO memberDTO = MemberDTO.builder().memberId(member.getMemberId()).build();
        MovieDTO movieDTO = entityToDTO(movie);
        MovieInfoDTO movieInfoDTO = entityToDTO(movieInfo, movieDTO);
        PayDTO payDTO = PayDTO.builder()
                .pid(pay.getPid())
                .reserveSeat(pay.getReserveSeat())
                .totalPrice(pay.getTotalPrice())
                .memberDTO(memberDTO)
                .movieInfoDTO(movieInfoDTO)
                .build();
        return payDTO;
    }

    default MovieInfoDTO entityToDTO(MovieInfo movieInfo, MovieDTO movieDTO) throws ParseException {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date endTime = timeFormat.parse(movieInfo.getStartTime());
        endTime.setMinutes(endTime.getMinutes() + movieInfo.getMovie().getTime());

        MovieInfoDTO movieInfoDTO = MovieInfoDTO.builder()
                .mino(movieInfo.getMino())
                .date(movieInfo.getDate())
                .place(movieInfo.getPlace())
                .seat(movieInfo.getSeat())
                .startTime(movieInfo.getStartTime())
                .endTime(timeFormat.format(endTime))
                .movieDTO(movieDTO)
                .build();
        return movieInfoDTO;
    }

    default MovieInfo dtoToEntity(MovieInfoDTO movieInfoDTO){
        String seat = (movieInfoDTO.getSeat() == null || movieInfoDTO.getSeat().isEmpty()) ? "0".repeat(72) : movieInfoDTO.getSeat();
        MovieInfo movieInfo = MovieInfo.builder()
                .mino(movieInfoDTO.getMino())
                .date(movieInfoDTO.getDate())
                .place(movieInfoDTO.getPlace())
                .seat(seat)
                .startTime(movieInfoDTO.getStartTime())
                .movie(dtoToEntity(movieInfoDTO.getMovieDTO()))
                .build();
        return movieInfo;
    }

    default Movie dtoToEntity(MovieDTO movieDTO){
        Movie movie = Movie.builder()
                .mno(movieDTO.getMno())
                .name(movieDTO.getName())
                .summary(movieDTO.getSummary())
                .time(movieDTO.getTime())
                .imgName(movieDTO.getImgName())
                .path(movieDTO.getPath())
                .totalGrade(movieDTO.getTotalGrade())
                .build();
        return movie;
    }

    default MovieDTO entityToDTO(Movie movie){
        MovieDTO movieDTO = MovieDTO.builder()
                .mno(movie.getMno())
                .imgName(movie.getImgName())
                .time(movie.getTime())
                .name(movie.getName())
                .summary(movie.getSummary())
                .totalGrade(movie.getTotalGrade())
                .path(movie.getPath())
                .build();
        return movieDTO;
    }

    default MovieInfoDTO entityToDTO(MovieInfo movieInfo) throws ParseException {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date endTime = timeFormat.parse(movieInfo.getStartTime());
        endTime.setMinutes(endTime.getMinutes() + movieInfo.getMovie().getTime());
        MovieDTO movieDTO = MovieDTO.builder()
                .mno(movieInfo.getMovie().getMno())
                .name(movieInfo.getMovie().getName())
                .totalGrade(movieInfo.getMovie().getTotalGrade())
                .summary(movieInfo.getMovie().getSummary())
                .time(movieInfo.getMovie().getTime())
                .path(movieInfo.getMovie().getPath())
                .imgName(movieInfo.getMovie().getImgName())
                .build();

        MovieInfoDTO movieInfoDTO = MovieInfoDTO.builder()
                .mino(movieInfo.getMino())
                .date(movieInfo.getDate())
                .place(movieInfo.getPlace())
                .seat(movieInfo.getSeat())
                .startTime(movieInfo.getStartTime())
                .endTime(timeFormat.format(endTime))
                .movieDTO(movieDTO)
                .build();
        return movieInfoDTO;
    }

    default Member DtoToEntity(MemberDTO memberDTO, PasswordEncoder passwordEncoder){
        Member member = Member.builder()
                .memberId(memberDTO.getMemberId())
                .password(passwordEncoder.encode(memberDTO.getPassword()))
                .role("USER")
                .build();
        return member;
    }

    default MemberDTO entityToDTO(Member member){
        MemberDTO memberDTO = MemberDTO.builder()
                .memberId(member.getMemberId())
                .role(member.getRole())
                .build();
        return memberDTO;
    }
}
