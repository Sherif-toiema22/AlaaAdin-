package com.company.AlaaAdinWebsite.controller;

import com.company.AlaaAdinWebsite.entity.FactoryOwner;
import com.company.AlaaAdinWebsite.service.FactoryOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
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

    @GetMapping("/factoryowners/{factoryownersId}")
    public Optional<FactoryOwner> getfactoryowners(@PathVariable Long factoryowner) {

        Optional<FactoryOwner> theFactoryOwner = factoryOwnerService.findById(factoryowner);

        if (theFactoryOwner == null) {
            throw new RuntimeException("Employee id not found - " + factoryowner);
        }

        return theFactoryOwner;
    }
    @PostMapping("/factoryowners")
    public FactoryOwner addEmployee(@RequestBody FactoryOwner factoryOwner) {

        FactoryOwner factoryOwner1= factoryOwnerService.save(factoryOwner);

        return factoryOwner1;
    }






}
