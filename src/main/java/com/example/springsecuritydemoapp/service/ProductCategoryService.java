package com.example.springsecuritydemoapp.service;


import com.example.springsecuritydemoapp.entity.ProductCategory;
import com.example.springsecuritydemoapp.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public ProductCategory getProductCategoryById(Integer categoryId){
      Optional<ProductCategory> productCategory= productCategoryRepository.findById(categoryId);

      if(productCategory.isPresent())
          return productCategory.get();
      else
          throw new EntityNotFoundException("product category with category id : "+categoryId+" not found");
    }

    public List<ProductCategory> listProductCategory(){
       return productCategoryRepository.findAll();
    }

    public ProductCategory addProductCategory(ProductCategory productCategory){
        ProductCategory newProductCategory = productCategoryRepository.save(productCategory);
        return newProductCategory;
    }

    public ProductCategory updateProductCategory(ProductCategory productCategory){

        Optional<ProductCategory> existingProductCategory = productCategoryRepository.findById(productCategory.getCategoryId());
        if(!existingProductCategory.isPresent())
            throw new EntityNotFoundException("product category with category id : "+productCategory.getCategoryId()+" not found");

         ProductCategory updatedProductCategory = existingProductCategory.get();
         updatedProductCategory.setCategoryName(productCategory.getCategoryName());
         productCategoryRepository.save(updatedProductCategory);
         return updatedProductCategory;
    }

    public void deleteProductCategory(Integer categoryId){

        Optional<ProductCategory> existingProductCategory = productCategoryRepository.findById(categoryId);
        if(!existingProductCategory.isPresent())
            throw new EntityNotFoundException("product category with category id : "+categoryId+" not found");
        productCategoryRepository.deleteById(categoryId);

    }


}
