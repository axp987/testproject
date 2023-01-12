package com.spring.testproject.data.service;

import com.spring.testproject.data.dto.ProductDto;

public interface ProductService {
    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

    ProductDto getProduct(String productId);
}
