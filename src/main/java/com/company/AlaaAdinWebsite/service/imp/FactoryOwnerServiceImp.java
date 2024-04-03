package com.company.AlaaAdinWebsite.service.imp;

import com.company.AlaaAdinWebsite.dao.FactoryOwnerRepository;
import com.company.AlaaAdinWebsite.entity.FactoryOwner;
import com.company.AlaaAdinWebsite.service.FactoryOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FactoryOwnerServiceImp implements FactoryOwnerService {

    private final FactoryOwnerRepository factoryOwnerRepository;

    @Autowired
    public FactoryOwnerServiceImp(FactoryOwnerRepository theFactoryOwnerRepository){
        factoryOwnerRepository=theFactoryOwnerRepository;
    }

    @Override
    public List<FactoryOwner> findAll() {
        return factoryOwnerRepository.findAll();
    }

    @Override
    public Optional<FactoryOwner> findById(int theId) {
        return factoryOwnerRepository.findById( theId);
    }

    @Transactional
    @Override
    public FactoryOwner save(FactoryOwner factoryOwner) {

        return factoryOwner;
    }

    @Transactional
    @Override
    public void deleteById(int theId) {

    }
}
