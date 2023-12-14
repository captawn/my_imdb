package com.example.demo.mapper;

import com.example.demo.domain.ActorDomain;
import com.example.demo.dto.ActorDTO;
import com.example.demo.entity.ActorEntity;
import com.example.demo.entity.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActorMapperHelper {


    private final ObjectMapper mapper;

    @Autowired
    public ActorMapperHelper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<ActorDomain> convertActorEntityListToActorDomainList(List<ActorEntity> ActorEntities) {
        return ActorEntities.stream()
                .map(this::convertActorEntityToActorDomain)
                .collect(Collectors.toList());
    }

    public List<ActorDTO> convertActorDomainListToActorDTOList(List<ActorDomain> ActorDomains) {
        return ActorDomains.stream()
                .map(this::convertActorDomainToActorDTO)
                .collect(Collectors.toList());
    }

    public ActorDTO convertActorDomainToActorDTO(ActorDomain ActorDomain) {
        return mapper.convertValue(ActorDomain, ActorDTO.class);
    }

    public ActorEntity convertActorDomainToActorEntity(ActorDomain ActorDomain) {
        ActorEntity ActorEntity = mapper.convertValue(ActorDomain, ActorEntity.class);

        // Manually set the UserEntity for the ActorEntity
//        if (ActorDomain.getUser() != null) {
//            UserEntity userEntity = mapper.convertValue(ActorDomain.getUser(), UserEntity.class);
//            ActorEntity.setUserEntity(userEntity);
//        }

        return ActorEntity;
    }

    public ActorDomain convertActorDTOToActorDomain(ActorDTO ActorDTO) {
        return mapper.convertValue(ActorDTO, ActorDomain.class);
    }

    public ActorDomain convertActorEntityToActorDomain(ActorEntity ActorEntity) {
        ActorDomain domain = ActorDomain.builder().
                id(ActorEntity.getId())
//                .ActorNumber(ActorEntity.getActorNumber())
//                .user(userMapperHelper.convertUserEntityToUserDomain(ActorEntity.getUserEntity()))
                .build();

        return domain;


    }
}
