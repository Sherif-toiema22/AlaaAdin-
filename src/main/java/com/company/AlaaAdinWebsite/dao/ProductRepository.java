package com.company.AlaaAdinWebsite.dao;

import com.company.AlaaAdinWebsite.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
