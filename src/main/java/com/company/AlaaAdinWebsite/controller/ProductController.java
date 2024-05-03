package com.company.AlaaAdinWebsite.controller;

import com.company.AlaaAdinWebsite.dao.CategoryRepository;
import com.company.AlaaAdinWebsite.dao.FactoryOwnerRepository;
import com.company.AlaaAdinWebsite.dao.SubCategoryRepository;
import com.company.AlaaAdinWebsite.entity.Category;
import com.company.AlaaAdinWebsite.entity.FactoryOwner;
import com.company.AlaaAdinWebsite.entity.Product;
import com.company.AlaaAdinWebsite.entity.SubCategory;
import com.company.AlaaAdinWebsite.service.ProductService;
import jakarta.websocket.server.PathParam;
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
    private final CategoryRepository categoryRepository;
    private final FactoryOwnerRepository factoryOwnerRepository;
    private final SubCategoryRepository subCategoryRepository;

    @Autowired
    public ProductController(ProductService theProductService, CategoryRepository categoryRepository, FactoryOwnerRepository factoryOwnerRepository, SubCategoryRepository subCategoryRepository){
        this.productService=theProductService;
        this.categoryRepository = categoryRepository;
        this.factoryOwnerRepository = factoryOwnerRepository;
        this.subCategoryRepository = subCategoryRepository;
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
    public Product addProduct(@RequestBody Product product ,@RequestParam Optional<Integer> categoryID,
                              @RequestParam Optional<Integer> factoryID,@RequestParam Optional<Integer> subCategoryID) {

        product.setId(0);

        if(categoryID.isPresent())
        {
            Optional<Category> tempcategory= categoryRepository.findById(categoryID.get());
            if(tempcategory.isPresent())
            {
                product.setCategory(tempcategory.get());
            }
        }
        if(factoryID.isPresent()) {
            Optional<FactoryOwner> tempFactory = factoryOwnerRepository.findById(factoryID.get());
            if(tempFactory.isPresent())
            {
                product.setFactoryOwner(tempFactory.get());
            }
        }
        if(subCategoryID.isPresent())
        {
            Optional<SubCategory> tempsubCategory= subCategoryRepository.findById(subCategoryID.get());
            if(tempsubCategory.isPresent())
            {
                product.setSubCategory(tempsubCategory.get());
            }
        }
        return productService.save(product);
    }
    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @RequestParam Optional<Integer> categoryID,
                                                 @RequestParam Optional<Integer> subCategoryID, @RequestParam Optional<Integer> factoryID) {
//
//        product.setCategoryId(categoryID);
//        product.setSubCategoryId(subCategoryID);
//        product.setFactoryOwnerId(factoryID);
//
//        int categoryID = product.getCategory().getId();
//        int factoryID = product.getFactoryOwner().getId();
//        int subCategoryID = product.getSubCategory().getId();
//
//        product.setCategory(categoryRepository.findById(categoryID).get());
//        product.setSubCategory(subCategoryRepository.findById(subCategoryID).get());
//        product.setFactoryOwner(factoryOwnerRepository.findById(factoryID).get());

        if(categoryID.isPresent())
        {
            Optional<Category> tempcategory= categoryRepository.findById(categoryID.get());
            if(tempcategory.isPresent())
            {
                product.setCategory(tempcategory.get());
            }
        }
        if(factoryID.isPresent()) {
            Optional<FactoryOwner> tempFactory = factoryOwnerRepository.findById(factoryID.get());
            if(tempFactory.isPresent())
            {
                product.setFactoryOwner(tempFactory.get());
            }
        }
        if(subCategoryID.isPresent())
        {
            Optional<SubCategory> tempsubCategory= subCategoryRepository.findById(subCategoryID.get());
            if(tempsubCategory.isPresent())
            {
                product.setSubCategory(tempsubCategory.get());
            }
        }

        productService.save(product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable int productId) {

        Optional<Product> tempProduct= productService.findById(productId);

        // throw exception if null

        if (tempProduct.isEmpty()) {
            throw new RuntimeException("product id not found - " + productId);
        }

            tempProduct.get().setCategory(null);
            tempProduct.get().setSubCategory(null);
            tempProduct.get().setFactoryOwner(null);
            productService.deleteById(productId);
            return "Deleted product id - " + productId;
    }
}
