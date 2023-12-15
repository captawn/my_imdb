package com.example.demo.dto;


import com.example.demo.entity.MovieEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class ActorDTO {


    private Long id;


    private String name;
    private int yearOfBirth;
    private String gender;
    private String country;
    private List<MovieDTO> movieDTOs;


}
