package com.modulobytes.hrms_modulobytes.services;
import com.modulobytes.hrms_modulobytes.DTOs.Request.LocationRequestDTO;
import com.modulobytes.hrms_modulobytes.entity.Location;
import com.modulobytes.hrms_modulobytes.repository.LocationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationService {



    private final LocationRepository locationRepository;

    @Autowired
    private ModelMapper modelMapper;


    public void saveAll(List<LocationRequestDTO> locationRequestDTOs) {
        // Map LocationRequestDTO to Location entity
        List<Location> locations = locationRequestDTOs.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());

        // Save all entities
        locationRepository.saveAll(locations);
    }

    private LocalDateTime convertToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
    }

    private Location convertToEntity(LocationRequestDTO dto) {
        Location location = new Location();
        if (dto.getIsocode() == null) {
            System.out.println("isocode is null for location: " + dto.getName());
        }
        location.setIsocode(dto.getIsocode());  // This will print if isocode is null
        location.setName(dto.getName());
       // location.setParentId(dto.getParentId());
        location.setParentId(dto.getParentId());
        location.setType(dto.getType());
        location.setChangeDate(convertToLocalDateTime(new Date()));
        location.setCreateDate(convertToLocalDateTime(new Date()));
        return location;
    }


    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getLocationsByParentId(Long parentId) {
        return locationRepository.findByParentId(parentId);
    }

    public List<Location> getLocationsByType(String type) {
        return locationRepository.findByType(type);
    }

//    // Fetch all countries
//    public List<Location> getCountries() {
//        return locationRepository.findByTypeAndParentIsNull("Country");
//    }


//    public Optional<Location> getLocationByNameAndType(String name, String type) {
//        return locationRepository.findByNameAndType(name, type);
//    }
//    public List<Location> getLocationsByParentIdAndType(Long parentId, String type) {
//        return locationRepository.findByParentIdAndType(parentId, type);
//    }
    // Fetch states for a given country
//    public  List<Location> getStatesForCountry(Long countryId) {
//        return locationRepository.findByTypeAndParentId("State", countryId);
//    }
//
//    // Fetch cities for a given state
//    public List<Location> getCitiesForState(Long stateId) {
//        return locationRepository.findByTypeAndParentId("City", stateId);
//    }
//
     //Find location by name and type (Country, State, or City)
    public Optional<Location> getLocationByNameAndType(String name, String type) {
        return locationRepository.findByNameAndType(name, type);
    }
    public Optional<Location> getLocationByNameAndTypeState (String name, String type){
        return locationRepository.findByNameAndType(name,type);
    }

    public Optional<Location> getLocationByNameAndTypeCity(String name,String type){
        return locationRepository.findByNameAndType(name,type);
    }

//    public Optional<Location> getLocationByNameAndType(String name, String type) {
//        return locationRepository.findByNameAndType(name, type);
//    }

    // Get States for a Country (by country ID)
    public List<Location> getStatesForCountry(Long countryId) {
        return locationRepository.findByParentIdAndType(countryId, "State");
    }

    // Get Cities for a State (by state ID)
    public List<Location> getCitiesForState(Long stateId) {
        return locationRepository.findByParentIdAndType(stateId, "City");
    }





    // Fetch all locations
    public List<LocationRequestDTO> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream()
                .map(location -> modelMapper.map(location, LocationRequestDTO.class))
                .collect(Collectors.toList());
    }


    // Get states for a given country
//    public List<String> getStatesByCountry(String countryName) {
//        // Fetch the country record by its name
//        Location country = locationRepository.findByTypeAndName("Country", countryName)
//                .orElseThrow(() -> new IllegalArgumentException("Country not found"));
//
//        // Fetch all states linked to this country
//        return locationRepository.findByTypeAndParentId("State", country.getId())
//                .stream()
//                .map(Location::getName)
//                .toList();
//    }


    // Save a location
//    public LocationRequestDTO saveLocation(LocationRequestDTO locationRequestDTO) {
//        Location location = modelMapper.map(locationRequestDTO, Location.class);
//        Location savedLocation = locationRepository.save(location);
//        return modelMapper.map(savedLocation, LocationRequestDTO.class);
//    }

    public LocationRequestDTO saveLocation(LocationRequestDTO locationRequestDTO) {
        Location location = modelMapper.map(locationRequestDTO, Location.class);

//        // Check if location requires a parent (State or City)
//        if ("State".equals(location.getType())) {
//            if (locationRequestDTO.getParentId() == null) {
//                throw new IllegalArgumentException("State must have a parent (Country)");
//            }
//        } else if ("City".equals(location.getType())) {
//            if (locationRequestDTO.getParentId() == null) {
//                throw new IllegalArgumentException("City must have a parent (State)");
//            }
//        }

        Location savedLocation = locationRepository.save(location);
        return modelMapper.map(savedLocation, LocationRequestDTO.class);
    }





//    public List<LocationRequestDTO> getStatesByCountry(String country) {
//        Location countryLocation = locationRepository.findByNameAndType(country, "country");
//        if (countryLocation == null) {
//            throw new RuntimeException("Country not found: " + country);
//        }
//        List<Location> states = locationRepository.findByParentId(countryLocation.getId());
//        return states.stream()
//                .map(location -> modelMapper.map(location, LocationRequestDTO.class))
//                .collect(Collectors.toList());
//    }
//
//    public List<LocationRequestDTO> getCitiesByState(String state) {
//        Location stateLocation = locationRepository.findByNameAndType(state, "state");
//        if (stateLocation == null) {
//            throw new RuntimeException("State not found: " + state);
//        }
//        List<Location> cities = locationRepository.findByParentId(stateLocation.getId());
//        return cities.stream()
//                .map(location -> modelMapper.map(location, LocationRequestDTO.class))
//                .collect(Collectors.toList());
//    }
//






//    public void validateAddress(RegisteredAddressRequestDTO registeredAddressRequestDTO) {
//        Location country = locationRepository.findByNameAndType(registeredAddressRequestDTO.getCountry(), "country");
//        if (country == null) {
//            throw new RuntimeException("Invalid country: " + registeredAddressRequestDTO.getCountry());
//        }
//
//        Location state = locationRepository.findByNameAndType(registeredAddressRequestDTO.getState(), "state");
//        if (state == null || !state.getParent().getId().equals(country.getId())) {
//            throw new RuntimeException("Invalid state for the selected country: " + registeredAddressRequestDTO.getState());
//        }
//
//        Location city = locationRepository.findByNameAndType(registeredAddressRequestDTO.getCity(), "city");
//        if (city == null || !city.getParent().getId().equals(state.getId())) {
//            throw new RuntimeException("Invalid city for the selected state: " + registeredAddressRequestDTO.getCity());
//        }
    //}
}
