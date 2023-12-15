package com.example.demo.dto;


import com.example.demo.entity.MovieEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class DirectorDTO {

    private Long id;

    private String name;
    private int yearOfBirth;
    private String gender;
    private String country;
    private MovieDTO movieDTO;


}
