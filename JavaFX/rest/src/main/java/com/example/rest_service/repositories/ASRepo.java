package com.example.rest_service.repositories;

import com.example.rest_service.models.AdditionalService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ASRepo extends JpaRepository<AdditionalService, Integer> {
}
