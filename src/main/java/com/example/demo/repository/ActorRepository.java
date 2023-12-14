package com.example.demo.repository;

import com.example.demo.entity.AccountEntity;
import com.example.demo.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<ActorEntity,Long> {
}
