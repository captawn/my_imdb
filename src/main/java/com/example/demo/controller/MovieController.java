package com.example.demo.controller;




import com.example.demo.domain.MovieDomain;
import com.example.demo.dto.MovieDTO;
import com.example.demo.mapper.MovieMapperHelper;
import com.example.demo.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);


    private final MovieService movieService;
    private final MovieMapperHelper MovieMapperHelper;

    @Autowired
    public MovieController(MovieService MovieService, MovieMapperHelper movieMapperHelper) {
        this.movieService = MovieService;
        this.MovieMapperHelper = movieMapperHelper;
    }

    @GetMapping
    public List<MovieDTO> getAllMovies() {
        logger.info("Received request to get all Movies.");
        List<MovieDomain> MovieDomains = movieService.getAllMovie();
        return MovieMapperHelper.convertMovieDomainListToMovieDTOList(MovieDomains);
    }

    @PostMapping
    public Long saveMovie(@RequestBody MovieDTO movieDTO) {
        logger.info("Received request to save directorDTO: {}", movieDTO.toString());
        MovieDomain movieDomain = MovieMapperHelper.convertMovieDTOToMovieDomain(movieDTO);
        return movieService.saveMovie(movieDomain);
    }

    @GetMapping("/{movieId}")
    public MovieDTO getMovieById(@PathVariable Long movieId) {
        logger.info("Received request to get movie by ID: {}", movieId);
        MovieDomain movieDomain = movieService.findMovieById(movieId);
        return MovieMapperHelper.convertMovieDomainToMovieDTO(movieDomain);
    }

    @DeleteMapping("/{movieId}")
    public void deleteMovieById(@PathVariable Long movieId) {
        logger.info("Received request to delete movie by ID: {}", movieId);
        movieService.deleteMovieById(movieId);
    }
}
