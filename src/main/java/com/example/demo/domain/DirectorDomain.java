package com.example.demo.domain;


import com.example.demo.entity.MovieEntity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class DirectorDomain {

    private Long id;

    private String name;
    private int yearOfBirth;
    private String gender;
    private String country;
    private MovieDomain movieDomain;


}
