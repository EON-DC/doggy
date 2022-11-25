package com.doggy.dao;

import com.doggy.entity.Product;

public interface ProductDAO {

    Product saveProduct(Product product);

    Product getProduct(Long productId);
}
