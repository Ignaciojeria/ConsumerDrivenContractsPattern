package com.accountmanager.resource;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.yml")
public class ConsumidorResourceTest {

    @Value("${test}")
    private String test;

    @Autowired
    private MockMvc mockMvc;
    //Minuto 21:28
    //https://www.youtube.com/watch?v=VnEX18Jil2M
    @Test
    public void shouldCreateAccount() throws Exception{
        String body="{\"name\":\"ignacio\",\"username\":\"ignaciovl\",\"email\":\"ignaciovl.j@gmail.com\",\"password\":\"123456\"}";
        mockMvc.perform(
                post("/account")
                .contentType(APPLICATION_JSON_UTF8)
                .content(body))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                //Pasa el test siempre y cuando se resuelva correctamente la solicitud Http al endPoint /account
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                //El retorno del Json de la solicitud http espera un objeto que dentro se sus atributos clave:valor contiene: ("nombre":"ignacio")
                .andExpect(jsonPath("name",is("ignacio")));

    }

    @Test
    public void holaMundo(){
        System.out.println(test);
    }
}
