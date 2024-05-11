package com.company.AlaaAdinWebsite.service;

import com.company.AlaaAdinWebsite.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(int theId);
    Product save(Product product);
    void deleteById(int theId);
//    Page<Product> countSearch(String searchTerm, int page, int size);
    List<Product> getProductsInRange(int start, int end);
    List<Product> searchProduct(String searchKey,int start,int end );
    List<Product> productQuery(String searchKey, Optional<Integer> category, Optional<Integer> subCategory, Optional<Integer> factoryOwner, int start, int end );

}
