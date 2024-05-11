package com.company.AlaaAdinWebsite.dao;

import com.company.AlaaAdinWebsite.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    Page<Product> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrDetailsContainingIgnoreCase(
            String title, String description, String details, Pageable pageable);

//    Page<Product> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrDetailsContainingIgnoreCaseAndCategoryIdAndSubCategoryIdAndFactoryOwnerId(
//            String title, String description, String details, Optional<Integer> category, Optional<Integer> subCategory, Optional<Integer> factoryOwner, Pageable pageable);


    @Query("SELECT p FROM Product p WHERE (p.description LIKE %:keyword% OR p.details LIKE %:keyword% OR p.title LIKE %:keyword%) " +
            "AND (:category Is NULL OR p.category.id = :category)"+
            "AND (:subCategory Is NULL OR p.subCategory.id = :subCategory)"+
            "AND (:factoryOwner Is NULL OR  p.factoryOwner.id = :factoryOwner)")
    Page<Product> findByKeywordAndCategory(String keyword, Optional<Integer> category, Optional<Integer> subCategory,
                                           Optional<Integer> factoryOwner, Pageable pageable);
    int countByCategoryContainingOrSubcategoryContainingOrNameContaining(String category, String subcategory, String name);


//    @Query("SELECT p FROM Product p WHERE lower(p.title) LIKE %:keyword% " +
//            "or lower(p.description) LIKE %:keyword% " +
//            "or lower(p.details) LIKE %:keyword% ORDER BY p.id LIMIT :limit OFFSET :offset" )
//    List<Product> searchByProduct(@Param("keyword") String keyword,@Param("limit") int limit ,@Param("offset" )int offset);

}
