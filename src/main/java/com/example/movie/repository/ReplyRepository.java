package com.example.movie.repository;

import com.example.movie.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface ReplyRepository extends JpaRepository<Reply, Long> {

}
