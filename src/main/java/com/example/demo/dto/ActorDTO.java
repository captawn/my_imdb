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
@ToString

public class ActorDTO {


    private Long id;


    private String name;
    private int yearOfBirth;
    private String gender;
    private String country;


}
