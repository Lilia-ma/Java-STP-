package com.example.rest_service.models;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String roomType;
    private Integer roomNumber;
    private Integer floor;
    private Integer price;

}
