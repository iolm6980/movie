package com.example.movie.repository;

import com.example.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Modifying
    @Transactional
    @Query("update Movie m set totalGrade = :totalGrade where mno = :mno")
    void updateGrade(Long mno, Long totalGrade);
}
