package com.company.AlaaAdinWebsite.service;

import com.company.AlaaAdinWebsite.entity.FactoryOwner;

import java.util.List;
import java.util.Optional;

public interface FactoryOwnerService {
    List<FactoryOwner> findAll();
    Optional<FactoryOwner> findById(Long theId);
    void save(FactoryOwner factoryOwner);
    void deleteById(int theId);



}
