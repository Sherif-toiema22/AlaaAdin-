package com.company.AlaaAdinWebsite.service.imp;

import com.company.AlaaAdinWebsite.dao.ProductRepository;
import com.company.AlaaAdinWebsite.entity.Product;
import com.company.AlaaAdinWebsite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository, OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor) {
        this.productRepository = productRepository;
        this.openEntityManagerInViewInterceptor = openEntityManagerInViewInterceptor;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsInRange(int start, int end) {

        return productRepository.findAll().subList(start,end);
    }


    @Override
    public List<Product> searchProduct(String searchKey, int start, int end) {
        PageRequest pageRequest = PageRequest.of(start, end); // Page number is 0-based
        Page<Product> page = productRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrDetailsContainingIgnoreCase(
                searchKey, searchKey, searchKey, pageRequest);

// Extract the list of YourEntity objects
        List<Product> entityList = page.getContent();
        return entityList;

    }
    @Override
    public List<Product> productQuery(String searchKey, Optional<Integer> category, Optional<Integer> subCategory, Optional<Integer> factoryOwner, int start, int end) {
        PageRequest pageRequest = PageRequest.of(start, end); // Page number is 0-based
        Page<Product> page = productRepository.findByKeywordAndCategory(
                searchKey,category,subCategory,factoryOwner, pageRequest);

// Extract the list of YourEntity objects
        List<Product> entityList = page.getContent();
        return entityList;

    }
    @Override
    public int productsCount(String searchKey, Optional<Integer> category, Optional<Integer> subCategory, Optional<Integer> factoryOwner) {
        int searchedCount = productRepository.searchCount(
                searchKey,category,subCategory,factoryOwner);

        return searchedCount;

    }


    @Override
    public Optional<Product> findById(int theId) {
        return productRepository.findById(theId);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        productRepository.deleteById( theId);
    }


}
