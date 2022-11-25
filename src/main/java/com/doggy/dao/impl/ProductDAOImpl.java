package com.doggy.dao.impl;

import com.doggy.dao.ProductDAO;
import com.doggy.entity.Product;
import com.doggy.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductDAOImpl implements ProductDAO {


    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product getProduct(Long productId) {
        Product findProduct = productRepository
                .findById(productId)
                .orElseThrow(() -> new IllegalStateException("can not found id: " + productId));

        return findProduct;
    }
}
