package com.doggy;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping(path = "{productId}")
    public Product findById(@PathVariable("productId") Long productId) {
        return productService.findByIdProduct(productId);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        Long resultId = productService.saveProduct(product);
        return product;
    }

    @DeleteMapping(path = "delete/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
        return "deleted done : " + productId;
    }

    @PutMapping(path = "{productId}")
    public Product updateProduct(@PathVariable("productId") Product product) {
        productService.updateProduct(product);
        return product;
    }

    @GetMapping(path = "find/{productName}")
    public Product findProduct(@PathVariable("productName")String name){
        return productService.findByName(name);
    }
}
