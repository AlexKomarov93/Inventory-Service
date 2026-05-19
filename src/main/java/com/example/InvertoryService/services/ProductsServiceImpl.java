package com.example.InvertoryService.services;

import com.example.InvertoryService.entity.Products;
import com.example.InvertoryService.repos.ProductsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    private ProductsRepository productsRepository;

    @Override
    @Transactional
    public Products saveOrUpdate(String name, Integer quantity, BigDecimal price, BigDecimal sale) {
        Products product = Products.builder()
                .name(name)
                .quantity(quantity)
                .price(price)
                .sale(sale)
                .build();
        return productsRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        if (!productsRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Товар не найден");
        } else {
            productsRepository.deleteById(id);
        }

    }

    @Override
    public Products getProduct(Long id) {
        return productsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Товар не найден"));
    }

    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }
}
