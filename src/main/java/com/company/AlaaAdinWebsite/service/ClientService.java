package com.company.AlaaAdinWebsite.service;

import com.company.AlaaAdinWebsite.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> findAll();
    Optional<Client> findById(int theId);
    Client save(Client client);
    void deleteById(int theId);
}
