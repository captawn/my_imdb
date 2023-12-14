package com.example.demo.dto;

import com.example.demo.entity.ItemEntity;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CartDTO {

    private Long id;
    private String name;
}
