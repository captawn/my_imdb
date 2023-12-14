package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Movie",schema = "MV")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
