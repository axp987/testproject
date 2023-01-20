package com.spring.testproject.data.dao;

import com.spring.testproject.data.entity.ProductEntity;

import java.util.List;

public interface ProductDao {
    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(String productId);

    List<ProductEntity> getAllProduct();

    ProductEntity saveDaoProduct(ProductEntity productEntity);
}
