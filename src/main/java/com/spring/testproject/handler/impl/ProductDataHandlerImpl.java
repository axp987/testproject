package com.spring.testproject.handler.impl;

import com.spring.testproject.data.dao.ProductDao;
import com.spring.testproject.data.entity.ProductEntity;
import com.spring.testproject.handler.ProductDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {
    ProductDao productDAO;

    @Autowired
    public ProductDataHandlerImpl(ProductDao productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = new ProductEntity(productId, productName, productPrice, productStock);

        return productDAO.saveProduct(productEntity);
    }

    @Override
    public ProductEntity getProductEntity(String productId) {
        return productDAO.getProduct(productId);
    }

    @Override
    public List<ProductEntity> getAllProductEntity() {
        return productDAO.getAllProduct();
    }

    @Override
    public ProductEntity saveDataHandlerProduct(String productId, String productName, int productPrice, int ProductStock) {
        ProductEntity productEntity = new ProductEntity(productId, productName, productPrice, ProductStock);

        return productDAO.saveDaoProduct(productEntity);
    }


}
