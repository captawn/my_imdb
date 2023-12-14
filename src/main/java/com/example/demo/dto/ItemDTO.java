package com.example.demo.dto;

import com.example.demo.entity.CartEntity;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class ItemDTO {

    private Long id;
    private String itemName;
    private CartDTO cart;
}
