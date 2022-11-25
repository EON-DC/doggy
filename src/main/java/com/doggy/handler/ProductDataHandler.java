package com.doggy.handler;

import com.doggy.entity.Product;

public interface ProductDataHandler {

    Product saveProductEntity(Long productId, String productName, int productPrice, int productStock);

    Product getProductEntity(Long productId);
}
