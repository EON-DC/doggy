package com.doggy;


import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class QdslTest {


    @Autowired
    EntityManager em;


    @Test
    @Transactional

    void test1() {
        Product product = new Product(1L, "cd", 2, 3000);

        em.persist(product);


        JPAQueryFactory query = new JPAQueryFactory(em);
               Product result = query
                .selectFrom(QProduct.product)
                .fetchOne();

        assertThat(product).isEqualTo(result);
        assertThat(product.getId()).isEqualTo(result.getId());
    }

}
