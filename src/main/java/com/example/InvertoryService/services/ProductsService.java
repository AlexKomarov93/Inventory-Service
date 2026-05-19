package com.example.InvertoryService.services;

import com.example.InvertoryService.entity.Products;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface ProductsService {
    Products saveOrUpdate(String name, Integer quantity, BigDecimal price, BigDecimal sale);

    void deleteProduct(Long id);

    Products getProduct(Long id);

    List<Products> getAllProducts();


}
