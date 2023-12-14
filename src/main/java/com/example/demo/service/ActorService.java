package com.example.demo.service;

import com.example.demo.domain.ActorDomain;

import java.util.List;


public interface ActorService {
    List<ActorDomain> getAllActor();

    Long saveActor(ActorDomain ActorDomain);

    ActorDomain findActorById(Long ActorId);

    void deleteActorById(Long ActorId);
}
