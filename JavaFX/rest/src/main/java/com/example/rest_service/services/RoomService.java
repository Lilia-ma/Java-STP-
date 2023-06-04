package com.example.rest_service.services;

import com.example.rest_service.models.Room;
import com.example.rest_service.repositories.RoomRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RoomService {
    @Autowired
    RoomRepo roomRepo;

    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    public Room getRoomById(Integer id) {
        return roomRepo.findById(id).get();
    }

    public void create(Room room) {
        roomRepo.save(room);
    }

    public void update(Room room, Integer id) {
        Room roomToUpdate = roomRepo.findById(id).get();
        if (room.getRoomType() != null) {
            roomToUpdate.setRoomType(room.getRoomType());
        }
        if (room.getRoomNumber() != null) {
            roomToUpdate.setRoomNumber(room.getRoomNumber());
        }
        if (room.getFloor() != null) {
            roomToUpdate.setFloor(room.getFloor());
        }
        if (room.getPrice() != null) {
            roomToUpdate.setPrice(room.getPrice());
        }

        roomRepo.save(roomToUpdate);

    }

    public void delete(Integer id) {
        roomRepo.deleteById(id);
    }

}
