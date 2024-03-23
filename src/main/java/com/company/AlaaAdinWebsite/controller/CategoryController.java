package com.company.AlaaAdinWebsite.controller;

import com.company.AlaaAdinWebsite.entity.Category;
import com.company.AlaaAdinWebsite.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping("/categories")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/categories/{categoryId}")
    public Optional<Category> getCategotry(@PathVariable Long categoryId) {

        Optional<Category> theCategory = categoryService.findById(categoryId);

        if (theCategory == null) {
            throw new RuntimeException("category id not found - " + categoryId);
        }

        return theCategory;
    }
    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category) {

        category.setId(0L);

        Category category1= categoryService.save(category);

        return category1;
    }
    @PutMapping("/categories")
    public Category updateCategory(@RequestBody Category thecategory) {

        Category category = categoryService.save(thecategory);

        return category;
    }
    @DeleteMapping("/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) {

        Optional<Category> tempcategory= categoryService.findById(categoryId);

        // throw exception if null

        if (tempcategory == null) {
            throw new RuntimeException("category id not found - " + categoryId);
        }

        categoryService.deleteById(categoryId);

        return "Deleted category id - " + categoryId;
    }



}
