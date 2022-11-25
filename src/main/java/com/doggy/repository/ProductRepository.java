package com.doggy.repository;

import com.doggy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Long> {

    /**
     * 쿼리 메소드의 주제 키워드
     */

    List<Product> findByName(String name);

    List<Product> queryByName(String name);

    // 존재 유무
    boolean existsByName(String name);

    // 쿼리 결과 개수
    long countByName(String name);

    // 삭제
    void deleteByName(String name);

    long removeByName(String name);



}
