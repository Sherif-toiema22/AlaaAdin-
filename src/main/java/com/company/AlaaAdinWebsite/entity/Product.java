package com.company.AlaaAdinWebsite.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title ;

    @Column(name = "details")
    private String details;

    @Column(name = "rate")
    private int rate=3;

    @Column(name = "imageLink")
    private String imageLink;

    @Column(name = "price")
    private double price;


    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,
            CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "factory_owner_id")
    private FactoryOwner factoryOwner;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,
            CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,
            CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "category_id" )
    private Category category;

    public void setCategoryId(Optional<Integer> categoryID) {
        category.setId(categoryID.get());
    }

    public void setSubCategoryId(Optional<Integer> subCategoryId) {
        subCategory.setId(subCategoryId.get());
    }

    public void setFactoryOwnerId(Optional<Integer> factoryID) {
        factoryOwner.setId(factoryID.get());
    }
}
