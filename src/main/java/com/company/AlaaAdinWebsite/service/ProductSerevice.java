package com.company.AlaaAdinWebsite.service;

import com.company.AlaaAdinWebsite.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductSerevice {
    List<Product> findAll();
    Optional<Product> findById(Long theId);
    void save(Product product);
    void deleteById(Long theId);
}
