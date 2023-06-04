package com.example.rest_service.repositories;

import com.example.rest_service.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room, Integer> {
}
