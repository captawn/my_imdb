package com.example.demo.domain;


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


}
