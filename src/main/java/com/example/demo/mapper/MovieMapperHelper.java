package com.example.demo.mapper;

import com.example.demo.domain.MovieDomain;
import com.example.demo.dto.MovieDTO;
import com.example.demo.entity.MovieEntity;
import com.example.demo.entity.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapperHelper {


    private final ObjectMapper mapper;

    @Autowired
    public MovieMapperHelper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<MovieDomain> convertMovieEntityListToMovieDomainList(List<MovieEntity> MovieEntities) {
        return MovieEntities.stream()
                .map(this::convertMovieEntityToMovieDomain)
                .collect(Collectors.toList());
    }

    public List<MovieDTO> convertMovieDomainListToMovieDTOList(List<MovieDomain> MovieDomains) {
        return MovieDomains.stream()
                .map(this::convertMovieDomainToMovieDTO)
                .collect(Collectors.toList());
    }

    public MovieDTO convertMovieDomainToMovieDTO(MovieDomain MovieDomain) {
        return mapper.convertValue(MovieDomain, MovieDTO.class);
    }

    public MovieEntity convertMovieDomainToMovieEntity(MovieDomain MovieDomain) {
        MovieEntity MovieEntity = mapper.convertValue(MovieDomain, MovieEntity.class);

        // Manually set the UserEntity for the MovieEntity
//        if (MovieDomain.getUser() != null) {
//            UserEntity userEntity = mapper.convertValue(MovieDomain.getUser(), UserEntity.class);
//            MovieEntity.setUserEntity(userEntity);
//        }

//        return MovieEntity;
    return MovieEntity;
    }

    public MovieDomain convertMovieDTOToMovieDomain(MovieDTO MovieDTO) {
        return mapper.convertValue(MovieDTO, MovieDomain.class);
    }

    public MovieDomain convertMovieEntityToMovieDomain(MovieEntity MovieEntity) {
        MovieDomain domain = MovieDomain.builder().
                id(MovieEntity.getId())
                .name(MovieEntity.getName())
                .year(MovieEntity.getYear())
                .description(MovieEntity.getDescription())
                .duration(MovieEntity.getDuration())
                .build();

        return domain;


    }
}
