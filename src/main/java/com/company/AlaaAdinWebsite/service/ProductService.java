package com.company.AlaaAdinWebsite.service;

import com.company.AlaaAdinWebsite.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(int theId);
    Product save(Product product);
    void deleteById(int theId);
    List<Product> getProductsInRange(int start, int end);
}
