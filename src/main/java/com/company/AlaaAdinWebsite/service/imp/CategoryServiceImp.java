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
@Transactional
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
    public Optional<Category> findById(Long theId) {
        return categoryRepository.findById(theId);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long theId) {
        categoryRepository.deleteById(theId);

    }
}
