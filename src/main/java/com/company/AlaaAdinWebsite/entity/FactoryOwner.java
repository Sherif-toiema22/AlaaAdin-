package com.company.AlaaAdinWebsite.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

    @JsonIgnore
    @OneToMany(mappedBy = "factoryOwner", fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.DETACH,
            CascadeType.REFRESH,CascadeType.DETACH,CascadeType.REMOVE})
    private List<Product> products;


//    public FactoryOwner(FactoryOwner factoryOwner) {
//
//    }
}
