package com.example.rest_service.controllers;

import com.example.rest_service.models.Booking;
import com.example.rest_service.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping("")
    public List<Booking> getAllBooking() {
        return bookingService.getAllBooking();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Integer id) {
        try{
            Booking booking = bookingService.getBookingById(id);
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void addBooking(@RequestBody Booking booking){
        bookingService.create(booking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBooking(@PathVariable Integer id, @RequestBody Booking booking){
       try {
           bookingService.update(booking, id);
           return new ResponseEntity<>(HttpStatus.OK);
       }
       catch (NoSuchElementException e){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Integer id){
        bookingService.delete(id);
    }

}
