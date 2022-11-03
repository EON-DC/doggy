package com.doggy.controller;

import com.doggy.subtype.controller.AccountController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class AccountControllerTest {

    @Autowired
    private AccountController accountController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("RestAPI 에 등록하면 loginId가 반환되어야합니다.")
    public void test1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/accounts?")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"loginId\": \"mun\",\n" +
                                "  \"profileName\": \"park\"\n" +
                                "}"))
                .andExpect(MockMvcResultMatchers.content().string("saved : mun"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }
}