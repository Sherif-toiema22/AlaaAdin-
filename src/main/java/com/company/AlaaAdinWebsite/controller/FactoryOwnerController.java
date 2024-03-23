package com.company.AlaaAdinWebsite.controller;

import com.company.AlaaAdinWebsite.entity.FactoryOwner;
import com.company.AlaaAdinWebsite.service.FactoryOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class FactoryOwnerController {

    private FactoryOwnerService factoryOwnerService;

    @Autowired
    public FactoryOwnerController(FactoryOwnerService thefactoryOwnerService){
        this.factoryOwnerService=thefactoryOwnerService;
    }

    @GetMapping("/factoryowners")
    public List<FactoryOwner> findAll() {
        return factoryOwnerService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/factoryowners/{factoryownerId}")
    public Optional<FactoryOwner> getfactoryowners(@PathVariable Long factoryownerId) {

        Optional<FactoryOwner> theFactoryOwner = factoryOwnerService.findById(factoryownerId);

        if (theFactoryOwner == null) {
            throw new RuntimeException("Factory owner id not found - " + factoryownerId);
        }

        return theFactoryOwner;
    }
    @PostMapping("/factoryowners")
    public FactoryOwner addEmployee(@RequestBody FactoryOwner factoryOwner) {

        factoryOwner.setId(0L);

        FactoryOwner factoryOwner1= factoryOwnerService.save(factoryOwner);

        return factoryOwner1;
    }
    @PutMapping("/factoryowners")
    public FactoryOwner updateFactoryOwner(@RequestBody FactoryOwner thefactoryOwner) {

        FactoryOwner factoryOwner = factoryOwnerService.save(thefactoryOwner);

        return factoryOwner;
    }
    @DeleteMapping("/factoryowners/{factoryownerId}")
    public String deleteFactoryOwner(@PathVariable Long factoryownerId) {

        Optional<FactoryOwner> tempfactoryOwner= factoryOwnerService.findById(factoryownerId);

        // throw exception if null

        if (tempfactoryOwner == null) {
            throw new RuntimeException("Factory Owner id not found - " + factoryownerId);
        }

        factoryOwnerService.deleteById(factoryownerId);

        return "Deleted employee id - " + factoryownerId;
    }




}
