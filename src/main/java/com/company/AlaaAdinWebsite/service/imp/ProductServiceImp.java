package com.company.AlaaAdinWebsite.service.imp;

import com.company.AlaaAdinWebsite.dao.ProductRepository;
import com.company.AlaaAdinWebsite.entity.Product;
import com.company.AlaaAdinWebsite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> getProductsInRange(int start, int end) {
        PageRequest pageRequest = PageRequest.of(start, end);
        return productRepository.findAll(pageRequest);
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
