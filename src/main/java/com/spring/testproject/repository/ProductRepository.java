package com.spring.testproject.repository;

import com.spring.testproject.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    // JpaRepository 사용시 CRUD는 기본적으로 지원해줌(query문)
}
