package com.company.AlaaAdinWebsite.controller;

import com.company.AlaaAdinWebsite.entity.Client;
import com.company.AlaaAdinWebsite.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService theclientService){
        this.clientService=theclientService;
    }

    @GetMapping("/clients")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/clients/{clientId}")
    public Optional<Client> getClient(@PathVariable Long clientId) {

        Optional<Client> theClient = clientService.findById(clientId);

        if (theClient == null) {
            throw new RuntimeException("client id not found - " + clientId);
        }

        return theClient;
    }
    @PostMapping("/clients")
    public Client addClient(@RequestBody Client client) {

        client.setId(0L);

        Client client1= clientService.save(client);

        return client1;
    }
    @PutMapping("/clients")
    public Client updateClient(@RequestBody Client theclient) {

        Client client = clientService.save(theclient);

        return client;
    }

    @DeleteMapping("/clients/{clientId}")
    public String deleteClient(@PathVariable Long clientId) {

        Optional<Client> tempclient= clientService.findById(clientId);

        // throw exception if null

        if (tempclient == null) {
            throw new RuntimeException("client id not found - " + clientId);
        }

        clientService.deleteById(clientId);

        return "Deleted client id - " + clientId;
    }

}
