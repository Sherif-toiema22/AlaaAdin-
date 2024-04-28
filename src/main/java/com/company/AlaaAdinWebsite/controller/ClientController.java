package com.company.AlaaAdinWebsite.controller;

import com.company.AlaaAdinWebsite.entity.Client;
import com.company.AlaaAdinWebsite.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
@CrossOrigin
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService theclientService){
        this.clientService=theclientService;
    }

    @GetMapping("/list")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("client/{clientId}")
    public Optional<Client> getClient(@PathVariable int clientId) {

        Optional<Client> theClient = clientService.findById(clientId);

        if (theClient.isEmpty()) {
            throw new RuntimeException("client id not found - " + clientId);
        }

        return theClient;
    }
    @PostMapping("/save")
    public Client addClient(@RequestBody Client client) {

        client.setId(0);

        return clientService.save(client);
    }
    @PutMapping("/update")
    public Client updateClient(@RequestBody Client theclient) {

        return clientService.save(theclient);
    }

    @DeleteMapping("/delete/{clientId}")
    public String deleteClient(@PathVariable int clientId) {

        Optional<Client> tempclient= clientService.findById(clientId);

        // throw exception if null

        if (tempclient.isEmpty()) {
            throw new RuntimeException("client id not found - " + clientId);
        }

        clientService.deleteById(clientId);

        return "Deleted client id - " + clientId;
    }

}
