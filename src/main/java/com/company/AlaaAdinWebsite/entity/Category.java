package com.company.AlaaAdinWebsite.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "imageLink")
    private String imageLink;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "category" ,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<SubCategory> subCategorys;

    @OneToMany(mappedBy = "category" ,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Product> products;


}
