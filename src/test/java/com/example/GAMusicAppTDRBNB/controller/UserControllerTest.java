package com.example.GAMusicAppTDRBNB.controller;

import MusicApp.config.JwtUtil;
import MusicApp.controller.UserController;
import MusicApp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private UserService userService;

    //===custom method===//
    private static String createDummyUserInJson(String name, String password) {
        return "{\"name\" : \"" + name + "\"," +
                "\"password\" : \"" + password + "\"}";
    }

    //===signup test===//

    @Test
    public void signup_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createDummyUserInJson("Kendrick", "Lamar"));

        when(userService.createUser(any())).thenReturn("1515"); //test passes
        //        when(userService.createUser(any())).thenReturn("2916"); //test fails

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"token\" :\"1515\"}"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());

    }

    //===login test===//
    @Test
    public void login_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createDummyUserInJson("Jermaine", "Cole"));

        when(userService.login(any())).thenReturn("Double Platinum"); //test passes
//        when(userService.login(any())).thenReturn("Boring"); //test fails

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"token\" : \"countItUp\"}"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());

    }
}
