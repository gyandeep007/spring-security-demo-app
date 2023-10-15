package com.example.springsecuritydemoapp.service;

import com.example.springsecuritydemoapp.entity.ProductCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    public List<ProductCategory> listProductCategory(){
        logger.info("listing product service");
        return Collections.emptyList();
    }

    public String productService(){
        logger.info("listing product service");
        return "random produuct service";
    }
}
