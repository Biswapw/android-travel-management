package com.example.travel_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="travel management system")
public class TravelManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "User_name", nullable = false)
    private String userName;
    @Column(name = "Number")
    private double number;
    @Column(name = "Name")
    private String name;
    @Column(name = "Gender")
    private String gender;
    @Column(name = "Country")
    private String country;
    @Column(name = "Address")
    private String address;
    @Column(name = "Phone")
    private double phone;
    @Column(name = "E_mail")
    private String email;

}