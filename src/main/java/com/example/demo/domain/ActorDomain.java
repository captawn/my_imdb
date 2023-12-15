package com.example.demo.domain;


import com.example.demo.entity.MovieEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ActorDomain {

    private Long id;
    private String name;
    private int yearOfBirth;
    private String gender;
    private String country;
    private List<MovieDomain> movieDomains;

}
