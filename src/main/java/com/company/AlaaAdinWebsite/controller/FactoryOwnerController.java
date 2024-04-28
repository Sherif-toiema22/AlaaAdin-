package com.company.AlaaAdinWebsite.controller;

import com.company.AlaaAdinWebsite.entity.FactoryOwner;
import com.company.AlaaAdinWebsite.service.FactoryOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/factoryOwners")
@CrossOrigin
public class FactoryOwnerController {

    private final FactoryOwnerService factoryOwnerService;

    @Autowired
    public FactoryOwnerController(FactoryOwnerService thefactoryOwnerService){
        this.factoryOwnerService=thefactoryOwnerService;
    }

    @GetMapping("/list")
    public List<FactoryOwner> findAll() {
        return factoryOwnerService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/factoryowner/{factoryownerId}")
    public Optional<FactoryOwner> getfactoryowners(@PathVariable int factoryownerId) {

        Optional<FactoryOwner> theFactoryOwner = factoryOwnerService.findById(factoryownerId);

        if (theFactoryOwner.isEmpty()) {
            throw new RuntimeException("Factory owner id not found - " + factoryownerId);
        }

        return theFactoryOwner;
    }
    @PostMapping("/save")
    public FactoryOwner addEmployee(@RequestBody FactoryOwner factoryOwner) {

        factoryOwner.setId(0);

        return factoryOwnerService.save(factoryOwner);
    }
    @PutMapping("/update")
    public FactoryOwner updateFactoryOwner(@RequestBody FactoryOwner thefactoryOwner) {

        return factoryOwnerService.save(thefactoryOwner);
    }
    @DeleteMapping("/delete/{factoryownerId}")
    public String deleteFactoryOwner(@PathVariable int factoryownerId) {

        Optional<FactoryOwner> tempfactoryOwner= factoryOwnerService.findById(factoryownerId);

        // throw exception if null

        if (tempfactoryOwner.isEmpty()) {
            throw new RuntimeException("Factory Owner id not found - " + factoryownerId);
        }

        factoryOwnerService.deleteById(factoryownerId);

        return "Deleted employee id - " + factoryownerId;
    }




}
