package com.company.AlaaAdinWebsite.service;

import com.company.AlaaAdinWebsite.entity.SubCategory;

import java.util.List;
import java.util.Optional;

public interface SubCategoryService {
    List<SubCategory> findAll();
    Optional<SubCategory> findById(Long theId);
    SubCategory save(SubCategory subCategory);
    void deleteById(Long theId);
}
