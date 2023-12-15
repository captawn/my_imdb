package com.example.demo.domain;


import com.example.demo.entity.DirectorEntity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class MovieDomain {

    private Long id;

    private String name;
    private int year;
    private String description;
    private int duration;
    private DirectorDomain directorDomain;

}
