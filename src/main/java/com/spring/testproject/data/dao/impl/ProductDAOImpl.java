package com.spring.testproject.data.dao.impl;

import com.spring.testproject.data.dao.ProductDao;
import com.spring.testproject.data.entity.ProductEntity;
import com.spring.testproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 데이터베이스 영역
@Service
public class ProductDAOImpl implements ProductDao {

    // 레포지토리
    ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId) {
        ProductEntity productEntity = productRepository.getById(productId);
        return productEntity;
    }

    @Override
    public List<ProductEntity> getAllProduct() {
        List<ProductEntity> productEntity = productRepository.findAll();
        return productEntity;
    }

    @Override
    public ProductEntity saveDaoProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }


}
