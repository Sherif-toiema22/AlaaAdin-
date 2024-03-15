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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subCategory")
public class subCategory {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "imageLink")
    private String imageLink;

    @Column(name = "title")
    private String title;

    //ForiegnKey of category
}
