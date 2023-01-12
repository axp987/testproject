package com.spring.testproject.data.dao;

import com.spring.testproject.data.entity.ProductEntity;

public interface ProductDao {
    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(String productId);
}
