package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    private String name;
    private int year;
    private String description;
    private int duration;

    @OneToMany(mappedBy = "movieEntity", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<DirectorEntity> directorEntity;

    @ManyToMany
    @JoinTable(
            name = "MOVIE_ACTOR",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<ActorEntity> actorEntities;
}
