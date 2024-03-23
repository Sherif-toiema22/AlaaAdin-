package com.company.AlaaAdinWebsite.service.imp;

import com.company.AlaaAdinWebsite.dao.ProductRepository;
import com.company.AlaaAdinWebsite.entity.Product;
import com.company.AlaaAdinWebsite.service.ProductSerevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImp implements ProductSerevice {

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
    public Optional<Product> findById(Long theId) {
        return productRepository.findById(theId);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long theId) {
        productRepository.deleteById(theId);
    }
}
