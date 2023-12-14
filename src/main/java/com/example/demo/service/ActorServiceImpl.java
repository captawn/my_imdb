package com.example.demo.service;

import com.example.demo.domain.ActorDomain;
import com.example.demo.entity.ActorEntity;
import com.example.demo.mapper.ActorMapperHelper;
import com.example.demo.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {


    private final ActorRepository actorRepository;
    private final ActorMapperHelper ActorMapperHelper;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository, ActorMapperHelper ActorMapperHelper) {
        this.actorRepository = actorRepository;
        this.ActorMapperHelper = ActorMapperHelper;
    }

    @Override
    public List<ActorDomain> getAllActor() {
        List<ActorEntity> ActorEntities = actorRepository.findAll();
        return ActorMapperHelper.convertActorEntityListToActorDomainList(ActorEntities);
    }

    @Override
    public Long saveActor(ActorDomain ActorDomain) {
        ActorEntity ActorEntity = ActorMapperHelper.convertActorDomainToActorEntity(ActorDomain);
        ActorEntity savedActor = actorRepository.save(ActorEntity);
        return savedActor.getId();
    }

    @Override
    public ActorDomain findActorById(Long ActorId) {
        Optional<ActorEntity> byId = actorRepository.findById(ActorId);
        if (byId.isPresent()) {
            ActorEntity ActorEntity = byId.get();
            return ActorMapperHelper.convertActorEntityToActorDomain(ActorEntity);
        }
        return null;
    }

    @Override
    public void deleteActorById(Long ActorId) {
        actorRepository.deleteById(ActorId);
    }
}
