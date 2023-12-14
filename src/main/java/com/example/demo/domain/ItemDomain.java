package com.example.demo.domain;


import com.example.demo.entity.CartEntity;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemDomain {

    private Long id;
    private String itemName;
    private CartDomain  cart;

}
