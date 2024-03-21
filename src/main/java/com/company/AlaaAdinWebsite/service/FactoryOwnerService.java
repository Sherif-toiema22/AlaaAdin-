package com.company.AlaaAdinWebsite.service;

import com.company.AlaaAdinWebsite.entity.FactoryOwner;

import java.util.List;
import java.util.Optional;


public interface FactoryOwnerService {
    List<FactoryOwner> findAll();
    Optional<FactoryOwner> findById(Long theId);
    FactoryOwner save(FactoryOwner factoryOwner);
    void deleteById(int theId);



}
