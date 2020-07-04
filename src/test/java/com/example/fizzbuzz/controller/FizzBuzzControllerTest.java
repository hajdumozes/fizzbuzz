package com.example.fizzbuzz.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class FizzBuzzControllerTest {

    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenWac_whenServletContext_thenItProvidesGreetController() {
        ServletContext servletContext = wac.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(wac.getBean("fizzBuzzController"));
    }

    // since FizzBuzz parameters could change in the future, and it is already unit tested, I focus on the untested areas here
    @Test
    public void getSequence_whenParameterIsNegativeNumber_thenItProvidesErrorAttribute() throws Exception {
        this.mockMvc.perform(get("/fizzbuzz").param("last", "-30"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("error"))
                .andExpect(model().attributeDoesNotExist("sequence"))
                .andExpect(view().name("index"));
    }

    @Test
    public void getSequence_whenParameterIsZero_thenItProvidesErrorAttribute() throws Exception {
        this.mockMvc.perform(get("/fizzbuzz").param("last", "0"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("error"))
                .andExpect(model().attributeDoesNotExist("sequence"))
                .andExpect(view().name("index"));
    }

    @Test
    public void getSequence_whenParameterIsPositiveNumber_thenItProvidesSequenceAttribute() throws Exception {
        this.mockMvc.perform(get("/fizzbuzz").param("last", "100"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("sequence"))
                .andExpect(view().name("index"));
    }

}