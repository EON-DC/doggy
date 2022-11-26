package com.doggy;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer stock;
    private Integer price;

    public Product() {
    }

    public Product(String name, Integer stock, Integer price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public Product(Long id, String name, Integer stock, Integer price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }

    public void updateProduct(String name, Integer stock, Integer price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }
}
