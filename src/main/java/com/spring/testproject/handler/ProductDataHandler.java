package com.spring.testproject.handler;

import com.spring.testproject.data.entity.ProductEntity;

import java.util.List;

public interface ProductDataHandler {
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice, int ProductStock);

    public ProductEntity getProductEntity(String productId);

    public List<ProductEntity> getAllProductEntity();

    public ProductEntity saveDataHandlerProduct(String productId, String productName, int productPrice, int ProductStock);
}
