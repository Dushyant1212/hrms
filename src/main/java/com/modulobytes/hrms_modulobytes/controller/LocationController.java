package com.modulobytes.hrms_modulobytes.controller;

import com.modulobytes.hrms_modulobytes.DTOs.Request.LocationRequestDTO;
import com.modulobytes.hrms_modulobytes.DTOs.Request.RegisteredAddressRequestDTO;
import com.modulobytes.hrms_modulobytes.entity.Location;
import com.modulobytes.hrms_modulobytes.repository.LocationRepository;
import com.modulobytes.hrms_modulobytes.services.LocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/locations")
//state name and id......
public class LocationController {
    @Autowired
    private LocationService locationService;




    @GetMapping
    public ResponseEntity<List<LocationRequestDTO>> getAllLocations() {
        List<LocationRequestDTO> locations = locationService.getAllLocations();
        return ResponseEntity.ok(locations);
    }

    @PostMapping
    public ResponseEntity<LocationRequestDTO> createLocation(@RequestBody LocationRequestDTO locationRequestDTO) {
        try {
            LocationRequestDTO savedLocation = locationService.saveLocation(locationRequestDTO);
            return ResponseEntity.ok(savedLocation);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/batch")
    public ResponseEntity<?> createBatchLocations(@RequestBody List<LocationRequestDTO> locationRequestDTOs) {
        locationService.saveAll(locationRequestDTOs);
        return ResponseEntity.ok("Locations saved successfully");
    }


    // Get locations by parent ID (e.g., states of a country, cities of a state)
    @GetMapping("/by-parent/{parentId}")
    public ResponseEntity<List<Location>> getLocationsByParentId(@PathVariable Long parentId) {
        List<Location> locations = locationService.getLocationsByParentId(parentId);
        return ResponseEntity.ok(locations);
    }

    // Get root-level locations (e.g., all countries)
    @GetMapping("/by-type/{type}")
    public ResponseEntity<List<Location>> getLocationsByType(@PathVariable String type) {
        List<Location> locations = locationService.getLocationsByType(type);
        return ResponseEntity.ok(locations);
    }

    // Get states by country
    @GetMapping("/states/{countryName}")
    public ResponseEntity<List<Location>> getStatesByCountry(@PathVariable String countryName) {
        // Get country location
        Optional<Location> countryLocation = locationService.getLocationByNameAndType(countryName, "Country");
        if (countryLocation.isEmpty()) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }

        // Get states for the given country
        List<Location> states = locationService.getStatesForCountry(countryLocation.get().getId());
        return ResponseEntity.ok(states);
    }

    // Get cities by state
    @GetMapping("/cities/{stateName}")
    public ResponseEntity<List<Location>> getCitiesByState(@PathVariable String stateName) {
        // Get state location
        Optional<Location> stateLocation = locationService.getLocationByNameAndType(stateName, "State");
        if (stateLocation.isEmpty()) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }

        // Get cities for the given state
        List<Location> cities = locationService.getCitiesForState(stateLocation.get().getId());
        return ResponseEntity.ok(cities);
    }










//    @GetMapping("/states")
//    public ResponseEntity<List<LocationRequestDTO>> getStates(@RequestParam String country) {
//        List<LocationRequestDTO> states = locationService.getStatesByCountry(country);
//        return ResponseEntity.ok(states);
//    }
//
//    @GetMapping("/cities")
//    public ResponseEntity<List<LocationRequestDTO>> getCities(@RequestParam String state) {
//        List<LocationRequestDTO> cities = locationService.getCitiesByState(state);
//        return ResponseEntity.ok(cities);
//    }

//    @PostMapping("/validate-address")
//    public ResponseEntity<String> validateAndRegisterAddress(@RequestBody @Valid RegisteredAddressRequestDTO address) {
//        // Call the validateAddress method from the LocationService
//        locationService.validateAddress(address);
//
//        // Further logic can go here (e.g., saving the address in another table if needed)
//        // For example: addressService.saveAddress(address);
//
//        return ResponseEntity.ok("Address successfully validated!");
//    }





}
