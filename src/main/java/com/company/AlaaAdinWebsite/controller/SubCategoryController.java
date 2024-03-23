package com.company.AlaaAdinWebsite.controller;

import com.company.AlaaAdinWebsite.entity.Product;
import com.company.AlaaAdinWebsite.entity.SubCategory;
import com.company.AlaaAdinWebsite.service.ProductService;
import com.company.AlaaAdinWebsite.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SubCategoryController {


    private SubCategoryService subCategoryService;

    @Autowired
    public SubCategoryController(SubCategoryService theSubCategoryService){
        this.subCategoryService=theSubCategoryService;
    }

    @GetMapping("/subCategories")
    public List<SubCategory> findAll() {
        return subCategoryService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/subCategories/{subcategoryId}")
    public Optional<SubCategory> getSubCategory(@PathVariable Long subcategoryId) {

        Optional<SubCategory> theSubcategory = subCategoryService.findById(subcategoryId);

        if (theSubcategory == null) {
            throw new RuntimeException("Sub Category id not found - " + subcategoryId);
        }

        return theSubcategory;
    }

    @PostMapping("/subcategories")
    public SubCategory addSubCategory(@RequestBody SubCategory subCategory) {

        subCategory.setId(0L);

        SubCategory subCategory1= subCategoryService.save(subCategory);

        return subCategory1;
    }
    @PutMapping("/subcategories")
    public SubCategory updateProduct(@RequestBody SubCategory subCategory) {

        SubCategory subcategory1 = subCategoryService.save(subCategory);

        return subcategory1;
    }

    @DeleteMapping("/subcategories/{subcategoryId}")
    public String deleteSubcategory(@PathVariable Long subcategoryId) {

        Optional<SubCategory> tempSubCategory= subCategoryService.findById(subcategoryId);

        // throw exception if null

        if (tempSubCategory == null) {
            throw new RuntimeException("sub category id not found - " + subcategoryId);
        }

        subCategoryService.deleteById(subcategoryId);

        return "Deleted sub category id - " + subcategoryId;
    }
}
