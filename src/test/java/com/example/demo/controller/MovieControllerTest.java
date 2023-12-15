package com.example.demo.controller;

import com.example.demo.dto.MovieDTO;
import com.example.demo.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieController.class)
@ComponentScan(basePackageClasses = MovieController.class)
//@Import({ActorMapperHelper.class})
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;


    @Test
    void getAllMovies() throws Exception {
        assertNotNull(mockMvc);
        ResultActions perform = mockMvc.perform(get("/movie"));
        System.out.println(perform);
//                .andExpect(status().isOk());
    }

    @Test
    void saveMovie() throws Exception {
        MovieDTO sampleMovieDTO = createSampleMovieDTO();
        String jsonBody = new ObjectMapper().writeValueAsString(sampleMovieDTO);

        ResultActions result = mockMvc.perform(post("/movie")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody));

        // Verify the response
        result.andExpect(status().isOk());

    }

    @Test
    void getMovieById() throws Exception {
        // Mock the service method to return a specific actor
//        ActorDTO actorDTO = createSampleActorDTO();
//        when(actorService.findActorById(1L)).thenReturn(ActorMapperHelper.convertActorDTOToActorDomain(actorDTO));


        // Perform the GET request for a specific actor ID

         mockMvc.perform(get("/movie/1")
                        .contentType(MediaType.APPLICATION_JSON));
//                .contentType(MediaType.APPLICATION_JSON));

        // Verify the response
//        result.andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.name").value("John Doe"));

        // Verify that the service method was called once
//        verify(actorService, times(1)).findActorById(1L);

    }

    @Test
    void deleteMovieById() throws Exception{

        ResultActions result = mockMvc.perform(delete("/movie/1")
                .contentType(MediaType.APPLICATION_JSON));


    }

    private MovieDTO createSampleMovieDTO() {
        return MovieDTO.builder()
                .name("John Doe")
                .description("Desc")
                .year(1990)
                .build();
    }
}