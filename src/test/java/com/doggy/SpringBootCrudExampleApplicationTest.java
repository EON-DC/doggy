package com.doggy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootCrudExampleApplicationTest {

    private static RestTemplate restTemplate;
    private String baseUrl = "http://localhost";
    @LocalServerPort
    private int port;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setUp() {
        baseUrl = baseUrl.concat(":").concat(port + "").concat("/api/v1/products");
    }

    @Test
    @Sql(statements = "Delete PRODUCT where name='headset'", executionPhase = AFTER_TEST_METHOD)
    public void testAddProduct() {
        Product product = new Product("headset", 2, 899);
        Product response = restTemplate.postForObject(baseUrl, product, Product.class);
        System.out.println("response = " + response);

        assertThat(response).isNotNull();
        assertEquals(response.getName(), "headset");
        assertEquals(response.getStock(), 2);
        assertEquals(response.getPrice(), 899);

//        Product findProduct = restTemplate.getForObject(baseUrl + "/find/headset", Product.class);
//        restTemplate.delete(baseUrl+ "/delete/{id}", findProduct.getId());
    }

    @Test
    @DisplayName("get 접속 시 전체 제품 가져와야함")
    @Sql(statements = "INSERT INTO product(id, name, stock, price) values (4, 'AC', 1, 34000)", executionPhase = BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE PRODUCT where product.id=4", executionPhase = AFTER_TEST_METHOD)
    void tdd_for_getProduct() {
        // given
        // when
        List<Product> products = restTemplate.getForObject(baseUrl, List.class);
        System.out.println("products = " + products);

        // then
        assertEquals(1, products.size());
    }

    @Test
    @DisplayName("전체 제품 가져오기")
    @Sql(statements = "INSERT INTO PRODUCT(id, name, stock, price) values (2, 'BC', 3, 12000)", executionPhase = BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE PRODUCT where id=2", executionPhase = AFTER_TEST_METHOD)
    void tdd_for_getOneProduct() {
        // given
        Product product = restTemplate.getForObject(baseUrl + "/{id}", Product.class, 2);
        // when

        // then
        assertThat(product).isNotNull();
        assertThat(product.getId()).isEqualTo(2);
        assertThat(product.getName()).isEqualTo("BC");
        assertThat(product.getStock()).isEqualTo(3);
        assertThat(product.getPrice()).isEqualTo(12000);
    }

    @Test
    @DisplayName("find/{name} 이름으로 검색 가능해야함")
    @Sql(statements = "INSERT INTO Product(id, name, stock, price) values (5, 'findMe', 5, 1000)",
            executionPhase = BEFORE_TEST_METHOD)
    void tdd_for_findByProductName() {
        // given
        Product findProduct = restTemplate.getForObject(baseUrl + "/find/{productName}", Product.class, "findMe");

        // when

        // then
        assertThat(findProduct.getId()).isEqualTo(5);
        assertThat(findProduct.getName()).isEqualTo("findMe");
        assertThat(findProduct.getStock()).isEqualTo(5);
        assertThat(findProduct.getPrice()).isEqualTo(1000);
    }





}
