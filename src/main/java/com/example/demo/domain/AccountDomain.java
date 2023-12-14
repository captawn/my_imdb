package com.example.demo.domain;

import com.example.demo.entity.UserEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AccountDomain {

    private Long id;
    private String accountNumber;
    private UserDomain user;
}
