package com.example.travel_management_system.service;

import com.example.travel_management_system.model.TravelManagement;
import com.example.travel_management_system.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelServiceImpl implements TravelService {

    private final TravelRepository travelRepository;

    @Autowired
    public TravelServiceImpl(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    @Override
    public TravelManagement saveTravelManagement(TravelManagement travelManagement) {
        return travelRepository.save(travelManagement);
    }

    @Override
    public List<TravelManagement> getAllTravelManagement() {
        return travelRepository.findAll();
    }

    @Override
    public TravelManagement getTravelManagementById(Long id) {
        return travelRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTravelManagement(Long id) {
        travelRepository.deleteById(id);
    }
}
