package com.example.rest_service.controllers;

import com.example.rest_service.models.Client;
import com.example.rest_service.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("")
    public List<Client> getAllClient() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Integer id) {
        try{
            Client client = clientService.getClientById(id);
            return new ResponseEntity<>(client, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void addClient(@RequestBody Client client){
        clientService.create(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Integer id, @RequestBody Client client){
       try {
           clientService.update(client, id);
           return new ResponseEntity<>(HttpStatus.OK);
       }
       catch (NoSuchElementException e){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Integer id){
        clientService.delete(id);
    }

}
