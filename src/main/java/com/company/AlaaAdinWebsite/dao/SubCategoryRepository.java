package com.company.AlaaAdinWebsite.dao;

import com.company.AlaaAdinWebsite.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory,Integer> {

    //No need to Write code;
}
