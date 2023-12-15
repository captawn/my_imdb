package com.example.demo.dto;


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


}
