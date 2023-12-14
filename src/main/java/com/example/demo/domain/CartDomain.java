package com.example.demo.domain;


import com.example.demo.entity.ItemEntity;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CartDomain {

    private Long id;
    private String name;
}
