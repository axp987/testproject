package com.spring.testproject.data.service.impl;

import com.spring.testproject.data.dto.ProductDto;
import com.spring.testproject.data.entity.ProductEntity;
import com.spring.testproject.data.service.ProductService;
import com.spring.testproject.handler.ProductDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class  ProductServiceImpl implements ProductService {
    ProductDataHandler productDataHandler;

    // 의존성 주입 (싱글턴)
    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler) {
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);

        ProductDto productDto = new ProductDto(productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getProductPrice(),
                productEntity.getProductStock());

        System.out.println(productDto);
        return productDto;
    }

    @Override
    public ProductDto getProduct(String productId) {
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);

        ProductDto productDto = new ProductDto(productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getProductPrice(),
                productEntity.getProductStock());

        System.out.println(productDto);
        return productDto;
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<ProductEntity> productEntity = productDataHandler.getAllProductEntity();
        List<ProductDto> productDtos = new ArrayList<ProductDto>();
        ProductDto productDto;
        for(ProductEntity i: productEntity) {
            productDto = new ProductDto(i.getProductId(),
                    i.getProductName(),
                    i.getProductPrice(),
                    i.getProductStock()
            );
            productDtos.add(productDto);
        }
        System.out.println(productDtos);

        return productDtos;
    }

    @Override
    public ProductDto saveEntityProduct(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = productDataHandler.saveDataHandlerProduct(productId, productName, productPrice, productStock);

        ProductDto productDto = new ProductDto(productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getProductPrice(),
                productEntity.getProductStock()
        );

        return productDto;
    }


}
