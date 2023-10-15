package com.example.springsecuritydemoapp.controller;


import com.example.springsecuritydemoapp.entity.ProductCategory;
import com.example.springsecuritydemoapp.service.ProductCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product-category")
public class ProductCategoryController {
    private Logger logger = LoggerFactory.getLogger(ProductCategoryController.class);
    private ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping()
    public List<ProductCategory> listProductCategoryById(){
    logger.info("Thread name : {}",Thread.currentThread().getName());
        return productCategoryService.listProductCategory();
    }
    @GetMapping("/service")
    public String productService(){
        logger.info("Thread name : {}",Thread.currentThread().getName());
        return productCategoryService.productService();
    }

    @GetMapping("/{categoryId}")
    public ProductCategory getProductCategoryById(@PathVariable("categoryId") Integer categoryId){

        return productCategoryService.getProductCategoryById(categoryId);
    }

    @PostMapping
    public ProductCategory createProductCategory(@RequestBody ProductCategory productCategory){

      return   productCategoryService.addProductCategory(productCategory);
    }
    @PutMapping
    public ProductCategory updateProductCategory(@RequestBody ProductCategory productCategory){

        return   productCategoryService.updateProductCategory(productCategory);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteProductCategory(@PathVariable("categoryId") Integer categoryId){
        productCategoryService.deleteProductCategory(categoryId);
    }

    @GetMapping("/gen")
    public void makeOutOfMemory(){
        List<Integer> numbers = new ArrayList<>();
        int i=1;
        while (true){
            numbers.add(i);
            i++;
        }
    }
}
