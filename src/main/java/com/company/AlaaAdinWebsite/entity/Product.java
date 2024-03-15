package com.company.AlaaAdinWebsite.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "imageLink")
    private String imageLink;


    //foriegn key of subcategory and factory owner


}
