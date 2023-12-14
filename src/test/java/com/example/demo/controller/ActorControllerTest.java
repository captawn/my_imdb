package com.example.demo.controller;

import com.example.demo.dto.ActorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebMvcTest(nimaController.class)
class ActorControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @InjectMocks
    private nimaController nimaController;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(nimaController).build();
    }


    @Test
    void getAllActorsTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("nima jan"));
    }









    @Test
    void saveActor() {

    }

    @Test
    void getActorById() {
    }

    @Test
    void deleteActorById() {
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