package com.example.InvertoryService.controller;
import com.example.InvertoryService.entity.Products;
import com.example.InvertoryService.services.ProductsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/invertoryService")
public class ProductsController {

    ProductsServiceImpl productsService;

    @GetMapping("/products")
    public List<Products> getListOfProducts() {
        return productsService.getAllProducts();

    }

    @GetMapping("/products/{product_id}")
    public Products getProductById(@PathVariable("product_id") Long product_id) {
        return productsService.getProduct(product_id);
    }

    @DeleteMapping("/products/{product_id}")
    public void deleteProductById(@PathVariable("product_id") Long product_id) {
        productsService.deleteProduct(product_id);
    }

    @PostMapping("/products")
    public Products addOrUpdateProduct(@RequestBody Products products) {
        Products product = productsService.saveOrUpdate(
                products.getName(),
                products.getQuantity(),
                products.getPrice(),
                products.getSale()
        );
        return product;
    }
}
