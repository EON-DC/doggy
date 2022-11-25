package com.doggy.handler.impl;

import com.doggy.dao.ProductDAO;
import com.doggy.entity.Product;
import com.doggy.handler.ProductDataHandler;
import com.doggy.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ProductDataHandlerImpl implements ProductDataHandler {

    private final ProductDAO productDAO;

    @Override
    public Product saveProductEntity(Long productId, String productName, int productPrice, int productStock) {
        Product product = new Product(productId, productName, productPrice, productStock);

        return productDAO.saveProduct(product);
    }

    @Override
    public Product getProductEntity(Long productId) {
        return productDAO.getProduct(productId);
    }

}
