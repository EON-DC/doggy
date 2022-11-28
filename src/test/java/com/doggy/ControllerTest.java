package com.doggy;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(ProductController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    @DisplayName("다 가져올 수 있는지?")
    void tdd_for_getProduct() throws Exception {


        Product product = new Product(1L, "CD", 3, 20000);

        // given
        given(productService.findByIdProduct(1L))
                .willReturn(product);

        mockMvc.perform(get("/api/v1/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.stock").exists())
                .andExpect(jsonPath("$.price").exists())
                .andDo(print());
        verify(productService).findByIdProduct(1L);
    }

    @Test
    @DisplayName("")
    void tdd_for_getAllProduct() throws Exception{
        // given
        Product product1 = new Product(1L, "Book", 3, 20000);
        Product product2 = new Product(3L, "D/C", 300, 1000);
        Product product3 = new Product(5L, "Movie", 23234, 12200);
        Product product4 = new Product(11L, "Cup", 13413, 23300);

        List<Product> list = new ArrayList<>();
        list.add(product1);
        list.add(product2);
        list.add(product3);
        list.add(product4);
        // when
        given(productService.findAll()).willReturn(list);

        this.mockMvc.perform(get("/api/v1/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(list.size()));
        // then
        verify(productService).findAll();
    }

    @Test
    @DisplayName("post 를 통해 product를 저장할 수 있는지")
    void tdd_for_saveProduct() throws Exception{
        // given
        Product product1 = new Product(1L, "Book", 3, 20000);
        String productJson = new ObjectMapper().writeValueAsString(product1);

        given(productService.saveProduct(product1)).willReturn(1L);

        // when
        this.mockMvc.perform(post("/api/v1/products")
                        .content(productJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.stock").exists())
                .andExpect(jsonPath("$.price").exists())
                .andDo(print());

        // then
        verify(productService).saveProduct(ArgumentMatchers.refEq(product1));
    }

    @Test
    @DisplayName("제품 삭제 가능한지?")
    void tdd_for_delete() throws Exception{
        // given
        Product product1 = new Product(1L, "Book", 100, 1000);
        given(productService.deleteProduct(1L)).willReturn(1L);


        // when
        this.mockMvc.perform(delete("/api/v1/products/delete/{productId}", 1L))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("deleted done : 1"))
                .andDo(print());

        // then
        verify(productService).deleteProduct(1L);

    }

    @Test
    @DisplayName("제품 수정 가능한지?")
    void tdd_for_updateProduct() throws Exception{
        // given
        Product changedProduct = new Product(1L, "Car", 5, 1000);
        String productJson = new ObjectMapper().writeValueAsString(changedProduct);
        given(productService.updateProduct(changedProduct)).willReturn(changedProduct);

        // when
        this.mockMvc.perform(put("/api/v1/products/update/{productId}", 1L)
                        .content(productJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.stock").exists())
                .andExpect(jsonPath("$.price").exists())
                .andDo(print());

        // then
        verify(productService).updateProduct(ArgumentMatchers.refEq(changedProduct));

    }

    @Test
    @DisplayName("이름으로 조회시 리스트 출력")
    void tdd_for_findByName() throws Exception{
        // given
        String nameForString = "Book";
        Product product1 = new Product(1L, nameForString, 3, 20000);

        List<Product> list = new ArrayList<>();
        list.add(product1);

        given(productService.findByName(nameForString)).willReturn(list);

        // when
        this.mockMvc.perform(get("/api/v1/products/find/{productName}", nameForString))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].name").value(nameForString));

        // then
        verify(productService).findByName(nameForString);
    }



}
