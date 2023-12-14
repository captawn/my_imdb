package com.example.demo.service;

import com.example.demo.domain.MovieDomain;
import com.example.demo.domain.MovieDomain;

import java.util.List;


public interface MovieService {
    List<MovieDomain> getAllMovie();

    Long saveMovie(MovieDomain MovieDomain);

    MovieDomain findMovieById(Long MovieId);

    void deleteMovieById(Long MovieId);
}
