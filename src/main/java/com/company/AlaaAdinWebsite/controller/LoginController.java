package com.company.AlaaAdinWebsite.controller;

import com.company.AlaaAdinWebsite.dao.ClientRepository;
import com.company.AlaaAdinWebsite.dao.FactoryOwnerRepository;
import com.company.AlaaAdinWebsite.entity.Client;
import com.company.AlaaAdinWebsite.entity.FactoryOwner;
import com.company.AlaaAdinWebsite.entity.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private FactoryOwnerRepository factoryOwnerRepository;

    @PostMapping("/login")
    public Object login(@RequestBody LoginRequest loginRequest) {
        Client client = clientRepository.findByEmail(loginRequest.getEmail());
        FactoryOwner factoryOwner=factoryOwnerRepository.findByEmail(loginRequest.getEmail());
        if (client != null ) {
            if(client.getPassword().equals(loginRequest.getPassword())) {
                return client.getId()+"\n"+client.getFirstName()+"\n"+client.getLastName()+"\n" +
                        client.getEmail()+"\n"+ client.getPassword()+"\n" + client.getAddress()+"\n"+ client.getPhone_number()
                        +"\nWelcome Client!";
            }else {
                return "Right client gmail but Wrong Password";
            }
            } else if (factoryOwner != null) {
            if (factoryOwner.getPassword().equals(loginRequest.getPassword())) {
                return factoryOwner.getId()+"\n"+factoryOwner.getName()+"\n"+factoryOwner.getAddress()+"\n"+
                        factoryOwner.getEmail()+"\n"+factoryOwner.getPassword()+"\n" +factoryOwner.getImageLink()+"\n"+factoryOwner.getIs_Public()+"\n"
                        +factoryOwner.getPhone_number()+"\n"+factoryOwner.getIsApproved()+"\nWelcome Factory Owner!";
            }else{
                return "Right factory owner gmail but Wrong Password";
            }
            }
//        else if ("ADMIN".equals(role)) {
//                return "Welcome Admin!";
//            }
        else 
        return "Invalid email or role not found";
    }
}
