package com.example.demo.controller;

import com.example.demo.mapper.ActorMapperHelper;
import com.example.demo.service.ActorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@WebMvcTest(ActorController.class)
@ComponentScan(basePackageClasses = ActorMapperHelper.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ActorService actorService;


    @Test
    void getAllActors() throws Exception {
        assertNotNull(mockMvc);
    }
}