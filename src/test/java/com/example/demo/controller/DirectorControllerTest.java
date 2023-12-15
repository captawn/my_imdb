package com.example.demo.controller;

import com.example.demo.dto.ActorDTO;
import com.example.demo.dto.DirectorDTO;
import com.example.demo.mapper.ActorMapperHelper;
import com.example.demo.mapper.DirectorMapperHelper;
import com.example.demo.service.ActorService;
import com.example.demo.service.DirectorService;
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

@WebMvcTest(DirectorController.class)
@ComponentScan(basePackageClasses = DirectorMapperHelper.class)
//@Import({ActorMapperHelper.class})
class DirectorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DirectorService directorService;


    @Test
    void getAllDirector() throws Exception {
        assertNotNull(mockMvc);
        ResultActions perform = mockMvc.perform(get("/director"));
        System.out.println(perform);
//                .andExpect(status().isOk());
    }

    @Test
    void saveDirector() throws Exception {
        DirectorDTO sampleActorDTO = createSampleActorDTO();
        String jsonBody = new ObjectMapper().writeValueAsString(sampleActorDTO);

        ResultActions result = mockMvc.perform(post("/director")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody));

        // Verify the response
        result.andExpect(status().isOk());

    }

    @Test
    void getDirectorById() throws Exception {
        // Mock the service method to return a specific actor
//        ActorDTO actorDTO = createSampleActorDTO();
//        when(actorService.findActorById(1L)).thenReturn(ActorMapperHelper.convertActorDTOToActorDomain(actorDTO));


        // Perform the GET request for a specific actor ID

         mockMvc.perform(get("/director/1")
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
    void deleteDirectorById() throws Exception{

        ResultActions result = mockMvc.perform(delete("/director/1")
                .contentType(MediaType.APPLICATION_JSON));


    }

    private DirectorDTO createSampleActorDTO() {
        return DirectorDTO.builder()
                .name("John Doe")
                .yearOfBirth(1990)
                .gender("Male")
                .country("USA")
                .build();
    }
}