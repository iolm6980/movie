package com.example.movie.repository;

import com.example.movie.entity.Pay;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;
public interface PayRepository extends JpaRepository<Pay, String> {
    @Query("select p from Pay p " +
            "inner join p.member mm " +
            "inner join p.movieInfo mi " +
            "inner join p.movieInfo.movie m")
    List<Pay> findByMemberMemberId(String memberId);
}
