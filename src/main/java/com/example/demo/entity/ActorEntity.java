package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "ACTOR",schema = "MV")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class ActorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private int yearOfBirth;
    private String gender;
    private String country;


    @ManyToMany(mappedBy = "actorEntities")
    private List<MovieEntity> movieEntities;
}
