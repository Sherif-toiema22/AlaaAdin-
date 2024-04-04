package com.company.AlaaAdinWebsite.service.imp;

import com.company.AlaaAdinWebsite.dao.CategoryRepository;
import com.company.AlaaAdinWebsite.entity.Category;
import com.company.AlaaAdinWebsite.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(int theId) {
        return categoryRepository.findById(theId);
    }

    @Override
    @Transactional
    public Category save(Category category) {
        categoryRepository.save(category);
        return category;
    }


    @Override
    @Transactional
    public void deleteById(int theId) {
        categoryRepository.deleteById(theId);

    }
}
