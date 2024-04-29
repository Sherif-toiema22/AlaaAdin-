package com.company.AlaaAdinWebsite.service.imp;

import com.company.AlaaAdinWebsite.dao.ClientRepository;
import com.company.AlaaAdinWebsite.entity.Client;
import com.company.AlaaAdinWebsite.service.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService {

    private ClientRepository clientRepository;

    ClientServiceImp (ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(int theId) {
        return clientRepository.findById( theId);
    }

    @Transactional
    @Override
    public Client save(Client client) {

        clientRepository.save(client);
        return client;
    }

    @Transactional
    @Override
    public void deleteById(int theId) {

    }
}
