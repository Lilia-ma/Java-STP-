package com.example.rest_service.repositories;

import com.example.rest_service.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Integer> {
}


