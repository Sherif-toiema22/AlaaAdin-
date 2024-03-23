package com.company.AlaaAdinWebsite.service;

import com.company.AlaaAdinWebsite.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> findAll();
    Optional<Client> findById(Long theId);
    void save(Client client);
    void deleteById(Long theId);
}
