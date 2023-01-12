package com.spring.testproject.controller;

import com.spring.testproject.data.dto.ProductDto;
import com.spring.testproject.data.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/product-api")
public class productController {
    private ProductService productService;

    @Autowired
    public productController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{productId}")
    public ProductDto getHaveDto(@PathVariable("productId") String productId) {
        return productService.getProduct(productId);
    }

    @PostMapping("/product")
    public ProductDto postSaveDto(@RequestBody ProductDto productDto) {
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }
}
