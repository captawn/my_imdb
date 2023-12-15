package com.example.demo.service;

import com.example.demo.domain.MovieDomain;
import com.example.demo.entity.MovieEntity;
import com.example.demo.mapper.MovieMapperHelper;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {


    private final MovieRepository MovieRepository;
    private final MovieMapperHelper MovieMapperHelper;

    @Autowired
    public MovieServiceImpl(MovieRepository MovieRepository, MovieMapperHelper MovieMapperHelper) {
        this.MovieRepository = MovieRepository;
        this.MovieMapperHelper = MovieMapperHelper;
    }

    @Override
    public List<MovieDomain> getAllMovie() {
        List<MovieEntity> MovieEntities = MovieRepository.findAll();
        List<MovieDomain> movieDomains = MovieMapperHelper.convertMovieEntityListToMovieDomainList(MovieEntities);
        return movieDomains;

    }

    @Override
    public Long saveMovie(MovieDomain MovieDomain) {
        MovieEntity MovieEntity = MovieMapperHelper.convertMovieDomainToMovieEntity(MovieDomain);
        MovieEntity savedMovie = MovieRepository.save(MovieEntity);
        return savedMovie.getId();
    }

    @Override
    public MovieDomain findMovieById(Long MovieId) {
        Optional<MovieEntity> byId = MovieRepository.findById(MovieId);
        if (byId.isPresent()) {
            MovieEntity MovieEntity = byId.get();
            return MovieMapperHelper.convertMovieEntityToMovieDomain(MovieEntity);
        }
        return null;
    }

    @Override
    public void deleteMovieById(Long MovieId) {
        MovieRepository.deleteById(MovieId);
    }
}
