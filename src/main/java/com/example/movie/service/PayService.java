package com.example.movie.service;

import com.example.movie.dto.MemberDTO;
import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.MovieInfoDTO;
import com.example.movie.dto.PayDTO;
import com.example.movie.entity.Member;
import com.example.movie.entity.Movie;
import com.example.movie.entity.MovieInfo;
import com.example.movie.entity.Pay;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public interface PayService {
    void register(PayDTO payDTO);
    List<PayDTO> getPayList(String memberId);
    String getToken(String apiKey, String secretKey) throws IOException;
    void deletePay(String pid);
    void refundRequest(String access_token, String merchant_uid, String reason) throws IOException;
//    default Pay DtoToEntity(PayDTO payDTO){
//        Member member = Member.builder().memberId(payDTO.getMemberDTO().getMemberId()).build();
//        MovieInfo movieInfo = MovieInfo.builder().mino(payDTO.getMovieInfoDTO().getMino()).build();
//        Pay pay = Pay.builder()
//                .pid(payDTO.getPid())
//                .reserveSeat(payDTO.getReserveSeat())
//                .totalPrice(payDTO.getTotalPrice())
//                .member(member)
//                .movieInfo(movieInfo)
//                .build();
//        return pay;
//    }
//
//    default PayDTO entityToDto(Pay pay, Member member, MovieInfo movieInfo, Movie movie) throws ParseException {
//        MemberDTO memberDTO = MemberDTO.builder().memberId(member.getMemberId()).build();
//        MovieDTO movieDTO = entityToDTO(movie);
//        MovieInfoDTO movieInfoDTO = entityToDTO(movieInfo, movieDTO);
//        PayDTO payDTO = PayDTO.builder()
//                .pid(pay.getPid())
//                .reserveSeat(pay.getReserveSeat())
//                .totalPrice(pay.getTotalPrice())
//                .memberDTO(memberDTO)
//                .movieInfoDTO(movieInfoDTO)
//                .build();
//        return payDTO;
//    }
//
//    default MovieDTO entityToDTO(Movie movie){
//        MovieDTO movieDTO = MovieDTO.builder()
//                .mno(movie.getMno())
//                .imgName(movie.getImgName())
//                .time(movie.getTime())
//                .name(movie.getName())
//                .summary(movie.getSummary())
//                .totalGrade(movie.getTotalGrade())
//                .path(movie.getPath())
//                .build();
//        return movieDTO;
//    }
//
//    default MovieInfoDTO entityToDTO(MovieInfo movieInfo, MovieDTO movieDTO) throws ParseException {
//        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
//        Date endTime = timeFormat.parse(movieInfo.getStartTime());
//        endTime.setMinutes(endTime.getMinutes() + movieInfo.getMovie().getTime());
//
//        MovieInfoDTO movieInfoDTO = MovieInfoDTO.builder()
//                .mino(movieInfo.getMino())
//                .date(movieInfo.getDate())
//                .place(movieInfo.getPlace())
//                .seat(movieInfo.getSeat())
//                .startTime(movieInfo.getStartTime())
//                .endTime(timeFormat.format(endTime))
//                .movieDTO(movieDTO)
//                .build();
//        return movieInfoDTO;
//    }
}
