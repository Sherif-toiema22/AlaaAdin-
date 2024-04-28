package com.company.AlaaAdinWebsite.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title ;

    @Column(name = "details")
    private String details;

    @Column(name = "rate")
    private int rate;

    @Column(name = "imageLink")
    private String imageLink;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,
            CascadeType.REFRESH,CascadeType.DETACH})
    private FactoryOwner factoryOwner;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,
            CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;



}
