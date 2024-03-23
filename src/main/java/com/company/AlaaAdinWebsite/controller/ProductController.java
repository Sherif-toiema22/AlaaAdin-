package com.company.AlaaAdinWebsite.controller;

import com.company.AlaaAdinWebsite.entity.Product;
import com.company.AlaaAdinWebsite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService theProductService){
        this.productService=theProductService;
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/products/{productId}")
    public Optional<Product> getProduct(@PathVariable Long productId) {

        Optional<Product> theProduct = productService.findById(productId);

        if (theProduct == null) {
            throw new RuntimeException("product id not found - " + productId);
        }

        return theProduct;
    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {

        product.setId(0L);

        Product product1= productService.save(product);

        return product1;
    }
    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product theProduct) {

        Product product = productService.save(theProduct);

        return product;
    }

    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable Long productId) {

        Optional<Product> tempProduct= productService.findById(productId);

        // throw exception if null

        if (tempProduct == null) {
            throw new RuntimeException("product id not found - " + productId);
        }

        productService.deleteById(productId);

        return "Deleted product id - " + productId;
    }
}
