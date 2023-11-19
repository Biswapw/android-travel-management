package com.example.travel_management_system.repository;

import com.example.travel_management_system.model.TravelManagement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepository extends JpaRepository<TravelManagement,Long> {

}
