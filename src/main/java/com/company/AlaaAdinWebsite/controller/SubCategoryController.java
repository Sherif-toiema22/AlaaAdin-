package com.company.AlaaAdinWebsite.controller;
import com.company.AlaaAdinWebsite.entity.SubCategory;
import com.company.AlaaAdinWebsite.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subCategories")
@CrossOrigin
public class SubCategoryController {


    private final SubCategoryService subCategoryService;

    @Autowired
    public SubCategoryController(SubCategoryService theSubCategoryService){
        this.subCategoryService=theSubCategoryService;
    }

    @GetMapping("/subCategories")
    public List<SubCategory> findAll() {
        return subCategoryService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/subCategory/{subcategoryId}")
    public Optional<SubCategory> getSubCategory(@PathVariable int subcategoryId) {

        Optional<SubCategory> theSubcategory = subCategoryService.findById(subcategoryId);

        if (theSubcategory.isEmpty()) {
            throw new RuntimeException("Sub Category id not found - " + subcategoryId);
        }

        return theSubcategory;
    }

    @PostMapping("/save")
    public SubCategory addSubCategory(@RequestBody SubCategory subCategory) {

        subCategory.setId(0);

        return subCategoryService.save(subCategory);
    }
    @PutMapping("/update")
    public SubCategory updateProduct(@RequestBody SubCategory subCategory) {

        return subCategoryService.save(subCategory);
    }

    @DeleteMapping("/delete/{subcategoryId}")
    public String deleteSubcategory(@PathVariable int subcategoryId) {

        Optional<SubCategory> tempSubCategory= subCategoryService.findById(subcategoryId);

        // throw exception if null

        if (tempSubCategory.isEmpty()) {
            throw new RuntimeException("sub category id not found - " + subcategoryId);
        }

        subCategoryService.deleteById(subcategoryId);

        return "Deleted sub category id - " + subcategoryId;
    }
}
