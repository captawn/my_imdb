package com.example.demo.mapper;

import com.example.demo.domain.DirectorDomain;
import com.example.demo.domain.MovieDomain;
import com.example.demo.dto.DirectorDTO;
import com.example.demo.dto.MovieDTO;
import com.example.demo.entity.DirectorEntity;
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

    private final DirectorMapperHelper directorMapperHelper;

    @Autowired
    public MovieMapperHelper(ObjectMapper mapper,DirectorMapperHelper directorMapperHelper) {
        this.mapper = mapper;
        this.directorMapperHelper = directorMapperHelper;
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
//        return mapper.convertValue(MovieDomain, MovieDTO.class);
        MovieDTO build = MovieDTO.builder()
                .id(MovieDomain.getId())
                .name(MovieDomain.getName())
                .year(MovieDomain.getYear())
                .description(MovieDomain.getDescription())
                .duration(MovieDomain.getDuration())
                .directorDTO(directorMapperHelper.convertDirectorDomainListToDirectorDTOList(MovieDomain.getDirectorDomain()))
                .build();
        return build;

    }

    public MovieEntity convertMovieDomainToMovieEntity(MovieDomain MovieDomain) {
        MovieEntity MovieEntity = mapper.convertValue(MovieDomain, MovieEntity.class);

        if (MovieDomain.getDirectorDomain() != null) {
            List<DirectorDomain> directorDomain = MovieDomain.getDirectorDomain();
            List<DirectorEntity> directorEntityList = directorMapperHelper.convertDirectorDomainListToDirectorEntityList(directorDomain);
            MovieEntity.setDirectorEntity(directorEntityList);

        }
        return MovieEntity;
    }

    public MovieDomain convertMovieDTOToMovieDomain(MovieDTO movieDTO) {
        MovieDomain movieDomain = mapper.convertValue(movieDTO, MovieDomain.class);

        if (movieDTO.getDirectorDTO() != null) {
            List<DirectorDomain> directorDomainList = directorMapperHelper.convertDirectorDTOListToDirectorDomainList(movieDTO.getDirectorDTO());
            movieDomain.setDirectorDomain(directorDomainList);
        }
        return movieDomain;

    }

    public MovieDomain convertMovieEntityToMovieDomain(MovieEntity MovieEntity) {
        MovieDomain domain = MovieDomain.builder().
                id(MovieEntity.getId())
                .name(MovieEntity.getName())
                .year(MovieEntity.getYear())
                .description(MovieEntity.getDescription())
                .duration(MovieEntity.getDuration())
                .directorDomain(directorMapperHelper.convertDirectorEntityListToDirectorDomainList(MovieEntity.getDirectorEntity()))
                .build();
        return domain;


    }
}
