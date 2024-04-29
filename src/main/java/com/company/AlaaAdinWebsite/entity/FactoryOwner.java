package com.company.AlaaAdinWebsite.entity;

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
@Table(name = "factoryOwners")
public class FactoryOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "Is_Public")
    private Boolean Is_Public;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "Phone_number")
    private String phone_number;

    @Column(name = "address")
    private String address;

    @Column(name = "imageLink")
    private String imageLink;

    @Column(name = "isApproved")
    private Boolean isApproved=false;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Product> products;


}
