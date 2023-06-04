package com.example.frontend.schemas;

import java.util.Date;
import java.util.List;

public class Booking {
    public Integer id;

    public Room room;

    public Client client;

    public Date arrivalDate;
    public Date departDate;

    public List<AdditionalService> services;

    public Integer price;

    @Override
    public String toString() {
        return "ID: " + id.toString() + " Room: " + room.roomNumber;
    }


}
