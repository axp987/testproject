package com.spring.testproject.repository;

import com.spring.testproject.data.entity.Product;
import com.spring.testproject.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    // JpaRepository 사용시 CRUD는 기본적으로 지원해줌(query문)

    /* 쿼리 메소드의 주제 키워드 */

    // 조회
    List<ProductEntity> findProductName(String name);
    List<ProductEntity> queryByProductName(String name);

    // 존재 유무
    boolean existsByProductName(String name);

    // 쿼리 갯수 조회
    long countByProductName(String name);

    // 값 개수 제한
    List<ProductEntity> findFirstByProductName(String name);
    List<ProductEntity> findTop3ByProductName(String name);

    /* 쿼리 메소드의 조건자 키워드 */
    // Is, Equals (생략 가능)
    // Logical Keyword : IS, Keyword Expressions: Is, Equals, (or no keyword)
    // findByNumber 메소드와 동일하게 동작
    ProductEntity findByProductIdIs(String id);
    ProductEntity findByProductIdEquals(String id);


    @Query("SELECT p FROM Product p WHERE p.price > 2000")
    List<Product> findByPriceBasis();

    @Query(value = "SELECT * FROM product WHERE p.price > 2000", nativeQuery = true)
    List<Product> findByPriceBasisNativeQuery();

    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> findByPriceWithParameter(Integer price);

    @Query(value = "SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findByPriceWithParameterNaming(Integer price);

    @Query("SELECT p FROM Product WHERE p.price > :pri")
    List<Product> findByPriceWithParameterNaming2(@Param("pri") Integer price);

    @Query(value = "SELECT * FROM product WHERE price > :price",
            countQuery = "SELECT count(*) FROM product WHERE price > ?1",
            nativeQuery = true)
    List<Product> findByPriceWithParameterPaging(Integer price, Pageable pageable);

}
