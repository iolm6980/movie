package com.example.movie.repository;

import com.example.movie.entity.Movie;
import com.example.movie.entity.MovieInfo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
public interface MovieInfoRepository extends JpaRepository<MovieInfo, Long> {
    @Query("select mi, m from MovieInfo mi left outer join Movie m on m = mi.movie where mi.date=:date group by m")
    List<MovieInfo> findByDate(String date);
    @EntityGraph(attributePaths = "movie")
    List<MovieInfo> findByDateAndMovieMno(String date, Long mno);
}
