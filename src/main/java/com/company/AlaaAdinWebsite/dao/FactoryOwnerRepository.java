package com.company.AlaaAdinWebsite.dao;

import com.company.AlaaAdinWebsite.entity.FactoryOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FactoryOwnerRepository extends JpaRepository<FactoryOwner,Integer> {

    // that's it ... no need to write any code LOL!
}
