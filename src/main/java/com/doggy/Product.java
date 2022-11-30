package com.doggy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "product")
@NoArgsConstructor(access = PROTECTED)
@ToString(of = {"id", "name", "stock", "price"})
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;
    private String name;
    private Integer stock;
    private Integer price;

    @ManyToOne(fetch = LAZY, optional = true)
    @JoinColumn(name = "category_id")
    private Category category;


    public Product(String name, Integer stock, Integer price, Category category) {
        this(name, stock, price);
        this.category = category;
    }

    public Product(String name, Integer stock, Integer price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.category = null;
    }

    public Product(Long id, String name, Integer stock, Integer price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.category = null;
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

    public void setCategory(Category category) {
        if (category != null) {
            category.getProducts().remove(this);
        }
        this.category = category;
        category.getProducts().add(this);
    }


}
