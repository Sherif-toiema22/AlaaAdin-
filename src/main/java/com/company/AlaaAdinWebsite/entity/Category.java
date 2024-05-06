package com.company.AlaaAdinWebsite.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "category" ,fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.DETACH,
            CascadeType.REFRESH,CascadeType.DETACH})
    private List<SubCategory> subCategorys;


    @JsonIgnore
    @OneToMany(mappedBy = "category" ,fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.DETACH,
            CascadeType.REFRESH,CascadeType.DETACH})
    private List<Product> products;


}
