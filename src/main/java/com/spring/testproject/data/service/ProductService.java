package com.spring.testproject.data.service;

import com.spring.testproject.data.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

    ProductDto getProduct(String productId);

    List<ProductDto> getAllProduct();

    ProductDto saveEntityProduct(String productId, String productName, int productPrice, int productStock);
}
