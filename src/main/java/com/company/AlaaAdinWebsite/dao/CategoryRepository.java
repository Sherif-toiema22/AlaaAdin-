package com.company.AlaaAdinWebsite.dao;

import com.company.AlaaAdinWebsite.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    //no need to write code;
}
