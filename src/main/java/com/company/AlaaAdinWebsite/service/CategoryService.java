package com.company.AlaaAdinWebsite.service;

import com.company.AlaaAdinWebsite.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findById(int theId);
    Category save(Category category);
    void deleteById(int theId);

}
