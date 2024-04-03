package com.company.AlaaAdinWebsite.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.data.repository.cdi.Eager;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id=0;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
    //product -> id , title
    //categoty -> id , title , link of image

    //SubCategoty -> id , title , link of image,foreign key of category
}
