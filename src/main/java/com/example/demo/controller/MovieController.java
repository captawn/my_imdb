package com.example.demo.controller;




import com.example.demo.domain.MovieDomain;
import com.example.demo.dto.MovieDTO;
import com.example.demo.mapper.MovieMapperHelper;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;
    private final MovieMapperHelper MovieMapperHelper;

    @Autowired
    public MovieController(MovieService MovieService, MovieMapperHelper movieMapperHelper) {
        this.movieService = MovieService;
        this.MovieMapperHelper = movieMapperHelper;
    }

    @GetMapping
    public List<MovieDTO> getAllMovies() {
        List<MovieDomain> MovieDomains = movieService.getAllMovie();
        return MovieMapperHelper.convertMovieDomainListToMovieDTOList(MovieDomains);
    }

    @PostMapping
    public Long saveMovie(@RequestBody MovieDTO MovieDTO) {
        MovieDomain MovieDomain = MovieMapperHelper.convertMovieDTOToMovieDomain(MovieDTO);
        return movieService.saveMovie(MovieDomain);
    }

    @GetMapping("/{movieId}")
    public MovieDTO getMovieById(@PathVariable Long MovieId) {
        MovieDomain MovieDomain = movieService.findMovieById(MovieId);
        return MovieMapperHelper.convertMovieDomainToMovieDTO(MovieDomain);
    }

    @DeleteMapping("/{movieId}")
    public void deleteMovieById(@PathVariable Long MovieId) {
        movieService.deleteMovieById(MovieId);
    }
}
