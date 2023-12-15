package com.example.demo.domain;


import com.example.demo.entity.ActorEntity;
import com.example.demo.entity.DirectorEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private List<DirectorDomain> directorDomain;
    private List<ActorDomain> actorDomains;

}
