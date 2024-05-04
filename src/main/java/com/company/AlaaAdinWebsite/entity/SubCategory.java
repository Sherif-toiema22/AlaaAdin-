package com.company.AlaaAdinWebsite.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subCategory")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "imageLink")
    private String imageLink;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,
            CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "subCategory", fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,
            CascadeType.DETACH,CascadeType.REFRESH,CascadeType.DETACH})
    private List<Product> products;
}
