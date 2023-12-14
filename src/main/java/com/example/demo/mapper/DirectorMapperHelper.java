package com.example.demo.mapper;

import com.example.demo.domain.DirectorDomain;
import com.example.demo.dto.DirectorDTO;
import com.example.demo.entity.DirectorEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DirectorMapperHelper {


    private final ObjectMapper mapper;

    @Autowired
    public DirectorMapperHelper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<DirectorDomain> convertDirectorEntityListToDirectorDomainList(List<DirectorEntity> DirectorEntities) {
        return DirectorEntities.stream()
                .map(this::convertDirectorEntityToDirectorDomain)
                .collect(Collectors.toList());
    }

    public List<DirectorDTO> convertDirectorDomainListToDirectorDTOList(List<DirectorDomain> DirectorDomains) {
        return DirectorDomains.stream()
                .map(this::convertDirectorDomainToDirectorDTO)
                .collect(Collectors.toList());
    }

    public DirectorDTO convertDirectorDomainToDirectorDTO(DirectorDomain DirectorDomain) {
        return mapper.convertValue(DirectorDomain, DirectorDTO.class);
    }

    public DirectorEntity convertDirectorDomainToDirectorEntity(DirectorDomain DirectorDomain) {
        DirectorEntity DirectorEntity = mapper.convertValue(DirectorDomain, DirectorEntity.class);

        // Manually set the UserEntity for the DirectorEntity
//        if (DirectorDomain.getUser() != null) {
//            UserEntity userEntity = mapper.convertValue(DirectorDomain.getUser(), UserEntity.class);
//            DirectorEntity.setUserEntity(userEntity);
//        }

        return DirectorEntity;
    }

    public DirectorDomain convertDirectorDTOToDirectorDomain(DirectorDTO DirectorDTO) {
        return mapper.convertValue(DirectorDTO, DirectorDomain.class);
    }

    public DirectorDomain convertDirectorEntityToDirectorDomain(DirectorEntity DirectorEntity) {
        DirectorDomain domain = DirectorDomain.builder().
                id(DirectorEntity.getId())
//                .DirectorNumber(DirectorEntity.getDirectorNumber())
//                .user(userMapperHelper.convertUserEntityToUserDomain(DirectorEntity.getUserEntity()))
                .build();

        return domain;


    }
}
