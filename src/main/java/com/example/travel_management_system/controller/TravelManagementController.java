package com.example.travel_management_system.controller;

import com.example.travel_management_system.model.TravelManagement;
import com.example.travel_management_system.service.TravelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travel-management")
public class TravelManagementController {

    private final TravelService travelService;

    @Autowired
    public TravelManagementController(TravelService travelService) {
        this.travelService = travelService;
    }

    @PostMapping("/create")
    public ResponseEntity<TravelManagement> createTravelManagement(@RequestBody TravelManagement travelManagement) {
        TravelManagement createdTravelManagement = travelService.saveTravelManagement(travelManagement);
        return new ResponseEntity<>(createdTravelManagement, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TravelManagement>> getAllTravelManagement() {
        List<TravelManagement> travelManagementList = travelService.getAllTravelManagement();
        return new ResponseEntity<>(travelManagementList, HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<TravelManagement> getTravelManagementById(@PathVariable Long id) {
        TravelManagement travelManagement = travelService.getTravelManagementById(id);
        if (travelManagement != null) {
            return new ResponseEntity<>(travelManagement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTravelManagement(@PathVariable Long id) {
        travelService.deleteTravelManagement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // Update Travel Management
    @PutMapping("/update/{id}")
    public ResponseEntity<TravelManagement> updateTravelManagement(
            @PathVariable Long id,
            @RequestBody TravelManagement updatedTravelManagement
    ) {
        TravelManagement existingTravelManagement = travelService.getTravelManagementById(id);

        if (existingTravelManagement == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Set the updated values for the existing object
        existingTravelManagement.setUserName(updatedTravelManagement.getUserName());
        existingTravelManagement.setId(updatedTravelManagement.getId());
        existingTravelManagement.setNumber(updatedTravelManagement.getNumber());
        existingTravelManagement.setName(updatedTravelManagement.getName());
        existingTravelManagement.setGender(updatedTravelManagement.getGender());
        existingTravelManagement.setCountry(updatedTravelManagement.getCountry());
        existingTravelManagement.setAddress(updatedTravelManagement.getAddress());
        existingTravelManagement.setPhone(updatedTravelManagement.getPhone());
        existingTravelManagement.setEmail(updatedTravelManagement.getEmail());


        // Save the updated object
        travelService.saveTravelManagement(existingTravelManagement);

        return new ResponseEntity<>(existingTravelManagement, HttpStatus.OK);
    }
}

