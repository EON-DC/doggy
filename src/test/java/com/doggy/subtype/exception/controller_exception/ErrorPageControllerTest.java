package com.doggy.subtype.exception.controller_exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ErrorPageControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("404 error 호출")
    void test01() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/error-page/404"))
                .andExpect(MockMvcResultMatchers.content().string(
                        "<!DOCTYPE html>\n" +
                                "<html lang=\"en\">\n" +
                                "<head>\n" +
                                "    <meta charset=\"UTF-8\">\n" +
                                "    <title>404</title>\n" +
                                "</head>\n" +
                                "<body>\n" +
                                "todo : 404 error page\n" +
                                "</body>\n" +
                                "</html>"
                ));
    }

}