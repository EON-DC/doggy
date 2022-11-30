package com.doggy;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

import static com.doggy.QProduct.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductTest {

    @Autowired
    EntityManager em;

    @Test
    @DisplayName("영속성 관리 가능해야함")
    @Transactional
    void tdd_for_entity() throws Exception{
        // given
        Category categoryA = new Category("book");
        Category categoryB = new Category("music");
        em.persist(categoryA);
        em.persist(categoryB);

        Product product1 = new Product( "yuna", 3, 20000,categoryA);
        Product product2 = new Product( "hip", 1000, 800, categoryB);
        em.persist(product1);
        em.persist(product2);

        em.flush();
        em.clear();
        // when
        List<Product> members = em.createQuery("select p from Product p", Product.class).getResultList();
        System.out.println("members = " + members);
        List<Category> categories = em.createQuery("select c from Category c", Category.class).getResultList();
        System.out.println("categories = " + categories);
        List<Product> resultList = em.createQuery("select p from Product  p where p.category = :category", Product.class)
                .setParameter("category", categoryA)
                .getResultList();

        System.out.println("resultList = " + resultList);

        // then
    }

    @Test
    @DisplayName("qdsl로도 동일하게 가져올 수 있어야함")
    @Transactional
    void tdd_for_qdsl() throws Exception{
        // given
        Category categoryA = new Category("book");
        Category categoryB = new Category("music");
        em.persist(categoryA);
        em.persist(categoryB);

        Product product1 = new Product( "yuna", 3, 20000,categoryA);
        Product product2 = new Product( "hip", 1000, 800, categoryB);
        em.persist(product1);
        em.persist(product2);

        em.flush();
        em.clear();
        // when
        JPAQueryFactory query = new JPAQueryFactory(em);
        Product findProduct = query.selectFrom(product)
                .where(product.name.eq("yuna"))
                .fetchOne();

        // then
        assertThat(findProduct.getId()).isEqualTo(product1.getId());
        assertThat(findProduct.getName()).isEqualTo(product1.getName());
        assertThat(findProduct.getStock()).isEqualTo(product1.getStock());
        assertThat(findProduct.getCategory().getId()).isEqualTo(product1.getCategory().getId());
        assertThat(findProduct.getCategory().getName()).isEqualTo(product1.getCategory().getName());

    }


}
