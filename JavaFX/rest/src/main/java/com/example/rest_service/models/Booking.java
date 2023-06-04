package com.example.rest_service.models;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "room")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;

    private Date arrivalDate;
    private Date departDate;

    @ManyToMany
    private List<AdditionalService> services;

    private Integer price;


}
