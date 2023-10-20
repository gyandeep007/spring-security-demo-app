package com.example.springsecuritydemoapp.service;

import com.example.springsecuritydemoapp.entity.ProductCategory;
import com.example.springsecuritydemoapp.repository.ProductCategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductCategoryServiceTest {

    @InjectMocks
    ProductCategoryService service;

    @Mock
    ProductCategoryRepository productCategoryRepository;
    @Test
    void getProductCategoryById() {

        List<ProductCategory> products = Arrays.asList(new ProductCategory(1,"A"),
                                                        new ProductCategory(2,"B"),
                new ProductCategory(3,"C"));

        when(productCategoryRepository.findAll()).thenReturn(products);

        List<ProductCategory> actual = service.listProductCategory();
        assertEquals(3,actual.size());
    }

    @Test
    void listProductCategory() {
    }

    @Test
    void addProductCategory() {
    }

    @Test
    void updateProductCategory() {
    }

    @Test
    void deleteProductCategory() {
    }
}
