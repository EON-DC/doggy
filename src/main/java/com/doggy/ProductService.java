package com.doggy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Long saveProduct(Product product) {
        productRepository.save(product);
        return product.getId();
    }

    public Product findByIdProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("cannot found id: " + productId));
        return product;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product updateProduct(Product product) {
        Product findOne = productRepository.findById(product.getId())
                .orElseThrow(() -> new IllegalStateException("cannot found id: " + product.getId()));
        findOne.updateProduct(product.getName(), product.getStock(), product.getPrice());
        return findOne;
    }

    public Long deleteProduct(Long productId) {
        Product findOne = findByIdProduct(productId);
        productRepository.delete(findOne);
        return productId;
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
