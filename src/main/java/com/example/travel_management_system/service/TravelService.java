package com.example.travel_management_system.service;

import com.example.travel_management_system.model.TravelManagement;

import java.util.List;

public interface TravelService {
 TravelManagement saveTravelManagement(TravelManagement travelManagement);

 List<TravelManagement> getAllTravelManagement();

 TravelManagement getTravelManagementById(Long id);

 void deleteTravelManagement(Long id);
}
