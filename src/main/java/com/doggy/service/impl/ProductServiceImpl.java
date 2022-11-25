package com.doggy.service.impl;

import com.doggy.dto.ProductDto;
import com.doggy.entity.Product;
import com.doggy.handler.ProductDataHandler;
import com.doggy.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDataHandler productDataHandler;

    @Override
    public ProductDto saveProduct(Long productId, String productName, int productPrice, int productStock) {
        Product product = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);
        ProductDto productDto = new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getStock());
        return productDto;
    }

    @Override
    public ProductDto getProduct(Long productId) {
        Product product = productDataHandler.getProductEntity(productId);
        ProductDto productDto = new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getStock());
        return productDto;
    }

}
