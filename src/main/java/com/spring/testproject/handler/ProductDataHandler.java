package com.spring.testproject.handler;

import com.spring.testproject.data.entity.ProductEntity;

public interface ProductDataHandler {
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice, int ProductStock);

    public ProductEntity getProductEntity(String productId);
}
