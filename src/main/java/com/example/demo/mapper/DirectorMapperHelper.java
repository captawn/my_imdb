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
//    private final MovieMapperHelper movieMapperHelper;

    @Autowired
    public DirectorMapperHelper(ObjectMapper mapper/*, MovieMapperHelper movieMapperHelper*/) {
        this.mapper = mapper;
//        this.movieMapperHelper = movieMapperHelper;
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

    public List<DirectorEntity> convertDirectorDomainListToDirectorEntityList(List<DirectorDomain> directorDomains) {
        List<DirectorEntity> directorEntityList = directorDomains.stream()
                .map(this::convertDirectorDomainToDirectorEntity)
                .collect(Collectors.toList());
        return directorEntityList;
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

    public List<DirectorDomain> convertDirectorDTOListToDirectorDomainList(List <DirectorDTO> directorDTO) {
        List<DirectorDomain> directorDomainList = directorDTO.stream()
                .map(this::convertDirectorDTOToDirectorDomain)
                .collect(Collectors.toList());
        return directorDomainList;
    }

    public DirectorDomain convertDirectorEntityToDirectorDomain(DirectorEntity DirectorEntity) {
        DirectorDomain domain = DirectorDomain.builder().
                id(DirectorEntity.getId())
                .name(DirectorEntity.getName())
                .yearOfBirth(DirectorEntity.getYearOfBirth())
                .gender(DirectorEntity.getGender())
                .country(DirectorEntity.getCountry())
//                .movieDomain(movieMapperHelper.convertMovieEntityToMovieDomain(DirectorEntity.getMovieEntity()))
                .build();

        return domain;


    }
}
