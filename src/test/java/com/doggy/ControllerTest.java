package com.doggy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
public class ControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    @DisplayName("")
    void tdd_for_getProduct() throws Exception {
        // given
        BDDMockito.given(productService.saveProduct(new Product())).willReturn(null);


    }

}
