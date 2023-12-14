package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.*;

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


}
