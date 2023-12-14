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

    private final MovieService MovieService;
    private final MovieMapperHelper MovieMapperHelper;

    @Autowired
    public MovieController(MovieService MovieService, MovieMapperHelper MovieMapperHelper) {
        this.MovieService = MovieService;
        this.MovieMapperHelper = MovieMapperHelper;
    }

    @GetMapping
    public List<MovieDTO> getAllMovies() {
        List<MovieDomain> MovieDomains = MovieService.getAllMovie();
        return MovieMapperHelper.convertMovieDomainListToMovieDTOList(MovieDomains);
    }

    @PostMapping
    public Long saveMovie(@RequestBody MovieDTO MovieDTO) {
        MovieDomain MovieDomain = MovieMapperHelper.convertMovieDTOToMovieDomain(MovieDTO);
        return MovieService.saveMovie(MovieDomain);
    }

    @GetMapping("/{MovieId}")
    public MovieDTO getMovieById(@PathVariable Long MovieId) {
        MovieDomain MovieDomain = MovieService.findMovieById(MovieId);
        return MovieMapperHelper.convertMovieDomainToMovieDTO(MovieDomain);
    }

    @DeleteMapping("/{MovieId}")
    public void deleteMovieById(@PathVariable Long MovieId) {
        MovieService.deleteMovieById(MovieId);
    }
}
