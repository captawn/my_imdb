package com.example.demo.repository;

import com.example.demo.entity.AccountEntity;
import com.example.demo.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Long> {
}
