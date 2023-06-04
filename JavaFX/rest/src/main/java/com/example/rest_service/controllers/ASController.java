package com.example.rest_service.controllers;

import com.example.rest_service.models.AdditionalService;
import com.example.rest_service.services.ASService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/as")
public class ASController {
    @Autowired
    ASService asService;

    /**
     * Возвращает список всех сервисов
     * @return List<AdditionalService>
     */
    @GetMapping("")
    public List<AdditionalService> getAllAS() {
        return asService.getAllAS();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdditionalService> getASById(@PathVariable Integer id) {
        try{
            AdditionalService as = asService.getASById(id);
            return new ResponseEntity<>(as, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void addAS(@RequestBody AdditionalService as){
        asService.create(as);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAS(@PathVariable Integer id, @RequestBody AdditionalService as){
       try {
           asService.update(as, id);
           return new ResponseEntity<>(HttpStatus.OK);
       }
       catch (NoSuchElementException e){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping("/{id}")
    public void deleteAS(@PathVariable Integer id){
        asService.delete(id);
    }

}
