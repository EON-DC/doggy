package com.doggy;

import com.doggy.configuration.SecurityConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest
@ContextConfiguration(classes = {EonApplication.class, SecurityConfiguration.class})
public class SecurityConfigTest {

    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @MockBean
    HomeController homeController;

    @BeforeEach
    void setup(){
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }


    @Test
    @DisplayName("home은 입장 가능")
    void tdd_for_home() throws Exception{
        // given
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("OK"));

        // when

        // then
    }

    @Test
    @DisplayName("인증 필요")
    void tdd_for_authorization() throws Exception{
        // given
        mockMvc.perform(get("/test"))
                .andExpect(status().isUnauthorized());

        // when

        // then
    }

}
