package com.example.movie.repository;

import com.example.movie.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayRepository extends JpaRepository<Pay, String> {
}
