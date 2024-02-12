package com.example.movie.repository;

import com.example.movie.entity.Movie;
import com.example.movie.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    @Query("select r.rno, r.content, r.grade, r.member.memberId from Reply r where r.movie.mno = :mno")
    Page<Object[]> getReplyList(Long mno, Pageable pageable);
    @Query("select avg(r.grade) from Reply r where r.movie.mno = :mno")
    Long getTotalGrade(Long mno);
}
