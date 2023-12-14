package com.example.demo.controller;

import org.junit.jupiter.api.BeforeEach; //
import org.junit.jupiter.api.Test; //
import org.mockito.InjectMocks; //
import org.springframework.beans.factory.annotation.Autowired; //
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; //
import org.springframework.test.web.servlet.MockMvc; //
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders; //
import org.springframework.test.web.servlet.result.MockMvcResultMatchers; //
import org.springframework.test.web.servlet.setup.MockMvcBuilders; //

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SampleController.class)
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private SampleController nimaController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(nimaController).build();
    }

    @Test
    void getAllActorsTest() throws Exception {
        mockMvc.perform(get("/test"))
                .andExpect(status().isOk())
                .andExpect(content().string("test passed"));
    }



}