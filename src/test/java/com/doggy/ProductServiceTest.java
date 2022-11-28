package com.doggy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductService productService;


    @Test
    void saveProduct() {
        Product product1 = new Product(1L, "CD", 3, 20000);

        given(productRepository.save(product1)).willReturn(product1);

        Long result = productService.saveProduct(product1);

        assertThat(result).isEqualTo(product1.getId());
        verify(productRepository).save(product1);

    }

    @Test
    void findByIdProduct() {
    }

    @Test
    void findAll() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void findByName() {
    }
}