package com.company.AlaaAdinWebsite.controller;

import com.company.AlaaAdinWebsite.entity.Product;
import com.company.AlaaAdinWebsite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService theProductService){
        this.productService=theProductService;
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/indexedProducts")
    public List<Product> getProductsInRange(
            @RequestParam(defaultValue = "0") int start,
            @RequestParam(defaultValue = "10") int end) {
        return productService.getProductsInRange(start, end);
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/product/{productId}")
    public Optional<Product> getProduct(@PathVariable int productId) {

        Optional<Product> theProduct = productService.findById(productId);

        if (theProduct.isEmpty()) {
            throw new RuntimeException("product id not found - " + productId);
        }

        return theProduct;
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword,
                                                        @RequestParam(defaultValue = "10") int limit,
                                                        @RequestParam(defaultValue = "0") int offset) {
        List<Product> products = productService.searchProduct(keyword, limit, offset);
        return products;
    }
    @GetMapping("/query")
    public List<Product> queryProducts(@RequestParam String keyword,
                                       @RequestParam Optional<Integer> category,
                                       @RequestParam Optional<Integer> subCategory,
                                       @RequestParam Optional<Integer> factoryOwner,
                                        @RequestParam(defaultValue = "10") int limit,
                                        @RequestParam(defaultValue = "0") int offset) {
        List<Product> products = productService.productQuery(keyword,category,subCategory,factoryOwner, limit, offset);
        return products;
    }

    @PostMapping("/save")
    public Product addProduct(@RequestBody Product product) {

        product.setId(0);

        return productService.save(product);
    }
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product theProduct) {

        return productService.save(theProduct);
    }

    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable int productId) {

        Optional<Product> tempProduct= productService.findById(productId);

        // throw exception if null

        if (tempProduct.isEmpty()) {
            throw new RuntimeException("product id not found - " + productId);
        }

        productService.deleteById(productId);

        return "Deleted product id - " + productId;
    }
}
