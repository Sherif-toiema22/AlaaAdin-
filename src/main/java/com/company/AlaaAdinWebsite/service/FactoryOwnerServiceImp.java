package com.company.AlaaAdinWebsite.service;

import com.company.AlaaAdinWebsite.dao.FactoryOwnerRepository;
import com.company.AlaaAdinWebsite.entity.FactoryOwner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FactoryOwnerServiceImp implements FactoryOwnerService{

    private FactoryOwnerRepository factoryOwnerRepository;

    @Autowired
    FactoryOwnerServiceImp(FactoryOwnerRepository theFactoryOwnerRepository){
        factoryOwnerRepository=theFactoryOwnerRepository;
    }

    @Override
    public List<FactoryOwner> findAll() {
        return factoryOwnerRepository.findAll();
    }

    @Override
    public Optional<FactoryOwner> findById(Long theId) {
        return factoryOwnerRepository.findById(theId);
    }

    @Override
    public void save(FactoryOwner factoryOwner) {

    }

    @Override
    public void deleteById(int theId) {

    }
}
