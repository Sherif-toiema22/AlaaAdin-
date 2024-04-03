package com.company.AlaaAdinWebsite.service.imp;

import com.company.AlaaAdinWebsite.dao.SubCategoryRepository;
import com.company.AlaaAdinWebsite.entity.SubCategory;
import com.company.AlaaAdinWebsite.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryServiceImp implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    @Autowired
    public SubCategoryServiceImp(SubCategoryRepository categoryRepository) {
        this.subCategoryRepository = categoryRepository;
    }

    @Override
    public List<SubCategory> findAll() {
        return subCategoryRepository.findAll();
    }

    @Override
    public Optional<SubCategory> findById(int theId) {
        return subCategoryRepository.findById(theId);
    }

    @Transactional
    @Override
    public SubCategory save(SubCategory subCategory) {
        subCategoryRepository.save(subCategory);
        return subCategory;
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        subCategoryRepository.deleteById( theId);

    }
}
