package com.example.demo.domain;

import com.example.demo.entity.AccountEntity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDomain {

    private Long id;
    private String username;
}
