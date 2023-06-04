package com.example.rest_service.services;

import com.example.rest_service.models.Client;
import com.example.rest_service.repositories.ClientRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClientService {
    @Autowired
    ClientRepo clientRepo;

    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    public Client getClientById(Integer id) {
        return clientRepo.findById(id).get();
    }

    public void create(Client client) {
        clientRepo.save(client);
    }

    public void update(Client client, Integer id) {
        Client clientToUpdate = clientRepo.findById(id).get();
        if (client.getName() != null) {
            clientToUpdate.setName(client.getName());
        }
        if (client.getSurname() != null) {
            clientToUpdate.setSurname(client.getSurname());
        }
        if (client.getMiddleName() != null) {
            clientToUpdate.setMiddleName(client.getMiddleName());
        }
        if (client.getDateOfBirth() != null) {
            clientToUpdate.setDateOfBirth(client.getDateOfBirth());
        }
        clientRepo.save(clientToUpdate);

    }

    public void delete(Integer id) {
        clientRepo.deleteById(id);
    }

}
