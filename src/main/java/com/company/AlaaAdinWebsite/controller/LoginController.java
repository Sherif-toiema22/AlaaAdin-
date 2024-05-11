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
                return"data:{\n\"id\": "+client.getId()+","+",\n"+"\"firstName\": "+"\""+client.getFirstName()+"\""+",\n"+"\""+"\"lastName\": "+"\""+client.getLastName()+"\",\n"+
                        "\"address\": "+"\""+client.getAddress()+"\",\n"+
                        "\"email\": "+"\""+client.getEmail()+"\",\n"+"\"password\": "+"\""+client.getPassword()+"\",\n" +
                        ",\n"+"\"phone\": "+"\""+client.getPhone_number()+"\",\n"+
                        "}\n"+"\"type\""+":\"Client\"";
            }else {
                return "Right client gmail but Wrong Password";
            }
            } else if (factoryOwner != null) {
            if (factoryOwner.getPassword().equals(loginRequest.getPassword())) {
                return "data:{\n\"id\": "+factoryOwner.getId()+",\n"+"\"title\": "+"\""+factoryOwner.getTitle()+"\",\n"+"\"name\": "+"\""+factoryOwner.getName()+"\""+
                        ",\n"+"\"address\": "+"\""+factoryOwner.getAddress()+"\",\n"+
                        "\"email\": "+"\""+factoryOwner.getEmail()+"\""+",\n"+"\"password\": "+"\""+factoryOwner.getPassword()+"\""+",\n" +"\"imageLink\": "+"\""+factoryOwner.getImageLink()+"\""+ ",\n"+
                        "\"isApproved\": "+factoryOwner.getIsApproved()+",\n"+"\"phone\": "+"\""+factoryOwner.getPhone_number()+"\""+",\n"+"\"isPublic\": "+factoryOwner.getIs_Public()+"\n"+
                        "}\n"+"\"type\""+":\"Factory Owner\"";
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
