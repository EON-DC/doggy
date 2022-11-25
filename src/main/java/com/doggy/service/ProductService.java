package com.doggy.service;

import com.doggy.dto.ProductDto;

public interface ProductService {

    ProductDto saveProduct(Long productId, String productName, int productPrice, int productStock);

    ProductDto getProduct(Long productId);
}
