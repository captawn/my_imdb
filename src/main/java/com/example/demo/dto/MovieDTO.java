package com.example.demo.dto;


import com.example.demo.entity.DirectorEntity;
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

public class MovieDTO {


    private Long id;
    private String name;
    private int year;
    private String description;
    private int duration;
    private List<DirectorDTO> directorDTO;

}
