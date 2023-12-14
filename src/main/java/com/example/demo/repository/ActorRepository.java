package com.example.demo.repository;

import com.example.demo.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<AccountEntity,Long> {
}
