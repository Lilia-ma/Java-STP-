package com.example.rest_service.services;

import com.example.rest_service.models.Booking;
import com.example.rest_service.repositories.BookingRepo;
import com.example.rest_service.repositories.RoomRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookingService {
    @Autowired
    BookingRepo bookingRepo;

    public List<Booking> getAllBooking() {
        return bookingRepo.findAll();
    }

    public Booking getBookingById(Integer id) {
        return bookingRepo.findById(id).get();
    }

    public void create(Booking booking) {
        bookingRepo.save(booking);
    }

    public void update(Booking booking, Integer id) {
        Booking bookingToUpdate = bookingRepo.findById(id).get();
        if (booking.getRoom() != null) {
            bookingToUpdate.setRoom(booking.getRoom());
        }
        if (booking.getClient() != null) {
            bookingToUpdate.setClient(booking.getClient());
        }
        if (booking.getArrivalDate() != null) {
            bookingToUpdate.setArrivalDate(booking.getArrivalDate());
        }
        if (booking.getDepartDate() != null) {
            bookingToUpdate.setDepartDate(booking.getDepartDate());
        }
        if (booking.getServices() != null) {
            bookingToUpdate.setServices(booking.getServices());
        }
        if (booking.getPrice() != null) {
            bookingToUpdate.setPrice(booking.getPrice());
        }
        bookingRepo.save(bookingToUpdate);

    }

    public void delete(Integer id) {
        bookingRepo.deleteById(id);
    }

}
