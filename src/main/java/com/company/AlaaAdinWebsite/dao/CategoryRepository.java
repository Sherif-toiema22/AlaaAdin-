package com.company.AlaaAdinWebsite.dao;

import com.company.AlaaAdinWebsite.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    //no need to write code;
}
