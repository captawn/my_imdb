package com.example.demo.controller;

import com.example.demo.dto.ActorDTO;
import com.example.demo.mapper.ActorMapperHelper;
import com.example.demo.service.ActorService;
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
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ActorController.class)
@ComponentScan(basePackageClasses = ActorMapperHelper.class)
//@Import({ActorMapperHelper.class})
class ActorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ActorService actorService;


    @Test
    void getAllActors() throws Exception {
        assertNotNull(mockMvc);
        ResultActions perform = mockMvc.perform(get("/actor"));
        System.out.println(perform);
//                .andExpect(status().isOk());
    }

    @Test
    void saveActors() throws Exception {
        ActorDTO actorDTO = createSampleActorDTO();
        String jsonBody = new ObjectMapper().writeValueAsString(actorDTO);

        ResultActions result = mockMvc.perform(post("/actor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody));

        // Verify the response
        result.andExpect(status().isOk());

    }

    @Test
    void getActorById() throws Exception {
        // Mock the service method to return a specific actor
//        ActorDTO actorDTO = createSampleActorDTO();
//        when(actorService.findActorById(1L)).thenReturn(ActorMapperHelper.convertActorDTOToActorDomain(actorDTO));


        // Perform the GET request for a specific actor ID

         mockMvc.perform(get("/actor/1")
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
    void deleteActorById() throws Exception{

        ResultActions result = mockMvc.perform(delete("/actor/1")
                .contentType(MediaType.APPLICATION_JSON));


    }

    private ActorDTO createSampleActorDTO() {
        return ActorDTO.builder()
                .name("John Doe")
                .yearOfBirth(1990)
                .gender("Male")
                .country("USA")
                .build();
    }
}