package com.doggy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Product product1 = new Product(1L, "CD", 3, 20000);
        given(productRepository.findById(1L)).willReturn(Optional.of(product1));

        Product findProduct = productService.findByIdProduct(1L);

        assertThat(findProduct).isEqualTo(product1);
        verify(productRepository).findById(1L);
    }

    @Test
    void findAll() {
        Product product1 = new Product(1L, "Book", 3, 20000);
        Product product2 = new Product(3L, "D/C", 300, 1000);
        Product product3 = new Product(5L, "Movie", 23234, 12200);
        Product product4 = new Product(11L, "Cup", 13413, 23300);

        List<Product> list = new ArrayList<>();
        list.add(product1);
        list.add(product2);
        list.add(product3);
        list.add(product4);

        given(productRepository.findAll()).willReturn(list);

        List<Product> products = productService.findAll();

        assertThat(products).isEqualTo(list);
        verify(productRepository).findAll();
    }

    @Test
    void updateProduct() {
        Product changedProduct = new Product(1L, "Car", 5, 1000);
        given(productRepository.findById(1L)).willReturn(Optional.of(changedProduct));

        Product testProduct = new Product(1L, "Book", 2, 2000);

        Product updatedProduct = productService.updateProduct(testProduct);
        assertThat(updatedProduct.getId()).isEqualTo(testProduct.getId());
        assertThat(updatedProduct.getName()).isEqualTo(testProduct.getName());
        assertThat(updatedProduct.getPrice()).isEqualTo(testProduct.getPrice());
        assertThat(updatedProduct.getStock()).isEqualTo(testProduct.getStock());

        verify(productRepository).findById(1L);
    }

    @Test
    void deleteProduct() {
        Product deletePlanProduct = new Product(1L, "Car", 5, 1000);
        given(productRepository.findById(1L)).willReturn(Optional.of(deletePlanProduct));
        Long result = productService.deleteProduct(1L);

        assertThat(result).isEqualTo(1L);

        verify(productRepository).delete(deletePlanProduct);


    }

    @Test
    void findByName() {
        Product deletePlanProduct = new Product(1L, "Car", 5, 1000);
        List<Product> arrayList = new ArrayList<>();
        arrayList.add(deletePlanProduct);
        given(productRepository.findByName("Car")).willReturn(arrayList);

        List<Product> result = productService.findByName("Car");
        assertThat(result).containsAll(arrayList);

    }
}