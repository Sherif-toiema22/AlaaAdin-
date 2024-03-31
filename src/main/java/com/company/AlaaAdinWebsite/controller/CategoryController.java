package com.company.AlaaAdinWebsite.controller;

import com.company.AlaaAdinWebsite.entity.Category;
import com.company.AlaaAdinWebsite.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping("/hi")
    public String sayHi() {
        return "hello";
    }


    @GetMapping("/list")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/{categoryId}")
    public Optional<Category> getCategory(@PathVariable Long categoryId) {

        Optional<Category> theCategory = categoryService.findById(categoryId);

        if (theCategory.isEmpty()) {
            throw new RuntimeException("category id not found - " + categoryId);
        }

        return theCategory;
    }

    @PostMapping("/save")
    public Category addCategory(@RequestBody Category category) {

        category.setId(0L);


        return categoryService.save(category);
//        return "redirect:/category/list";
    }
    @PutMapping("/update")
    public Category updateCategory(@RequestBody Category thecategory) {

        return categoryService.save(thecategory);
    }
    @DeleteMapping("/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) {

        Optional<Category> tempcategory= categoryService.findById(categoryId);

        // throw exception if null

        if (tempcategory.isEmpty()) {
            throw new RuntimeException("category id not found - " + categoryId);
        }

        categoryService.deleteById(categoryId);

        return "Deleted category id - " + categoryId;
    }



}
