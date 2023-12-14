package com.example.demo.dto;

import com.example.demo.entity.UserEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AccountDTO {


    private Long id;
    private String accountNumber;
    private UserEntity user;
}
