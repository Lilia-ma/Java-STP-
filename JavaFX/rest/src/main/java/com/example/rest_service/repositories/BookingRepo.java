package com.example.rest_service.repositories;

import com.example.rest_service.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
}

