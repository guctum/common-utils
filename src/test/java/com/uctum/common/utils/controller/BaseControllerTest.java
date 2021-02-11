package com.uctum.common.utils.controller;

import com.uctum.common.utils.service.JokeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@AutoConfigureMockMvc
public class BaseControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    JokeService jokeService;

    @Test
    public void getHello() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome to Gr0g Industries.")));
    }

    @Test
    public void getJoke() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/joke").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(notNullValue()));
    }

    @Test
    public void searchJoke() throws Exception {
        String searchParam = "cat";
        mvc.perform(
                MockMvcRequestBuilders.get("/searchJoke?searchParam=" + searchParam).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(notNullValue()));
        System.out.println(jokeService.getJoke(searchParam));
    }

    @Test
    public void getFact() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/chuck").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(notNullValue()));
    }
}
