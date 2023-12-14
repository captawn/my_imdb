package com.example.demo.dto;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class MovieDTO {


    private Long id;



    private String name;
    private int year;
    private String description;
    private int duration;

}
