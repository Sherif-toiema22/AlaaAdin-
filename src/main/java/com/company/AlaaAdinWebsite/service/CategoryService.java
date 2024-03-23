package com.company.AlaaAdinWebsite.service;

import com.company.AlaaAdinWebsite.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findById(Long theId);
    void save(Category category);
    void deleteById(Long theId);

}
