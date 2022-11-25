package com.doggy.service.impl;


import com.doggy.dto.ProductDto;
import com.doggy.entity.Product;
import com.doggy.handler.impl.ProductDataHandlerImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@Import({ProductDataHandlerImpl.class, ProductServiceImpl.class})
class ProductServiceImplTest {

    @MockBean
    ProductDataHandlerImpl productDataHandler;

    @Autowired
    ProductServiceImpl productService;

    @Test
    public void getProductTest() {
        Mockito.when(productDataHandler.getProductEntity(123L))
                .thenReturn(new Product(123L, "pen", 2000, 3000));

        ProductDto productDto = productService.getProduct(123L);

        assertThat(productDto.getProductId()).isEqualTo(123L);
        assertThat(productDto.getProductName()).isEqualTo("pen");
        assertThat(productDto.getProductPrice()).isEqualTo(2000);
        assertThat(productDto.getProductStock()).isEqualTo(3000);

        verify(productDataHandler).getProductEntity(123L);
    }

    @Test
    public void saveProductTest() {
        //given
        Mockito.when(productDataHandler
                        .saveProductEntity(123L, "pen", 2000, 3000))
                .thenReturn(new Product(123L, "pen", 2000, 3000));

        ProductDto productDto = productService
                .saveProduct(123L, "pen", 2000, 3000);

        assertThat(productDto.getProductId()).isEqualTo(123L);
        assertThat(productDto.getProductName()).isEqualTo("pen");
        assertThat(productDto.getProductPrice()).isEqualTo(2000);
        assertThat(productDto.getProductStock()).isEqualTo(3000);

        verify(productDataHandler)
                .saveProductEntity(123L, "pen", 2000, 3000);
    }
}