package com.modulobytes.hrms_modulobytes.Validation;

import com.modulobytes.hrms_modulobytes.entity.Location;
import com.modulobytes.hrms_modulobytes.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Component
public class RegisterAddressValidation {
    @Autowired
    private final LocationService locationService; // Remove the static modifier here

    public RegisterAddressValidation(LocationService locationService) {
        this.locationService = locationService;
    }

//    public RegisterAddressValidation(LocationService locationService) {
//        this.locationService = locationService;
//    }

    public String validateAddressLine2(String addressLine2) {
        if (addressLine2 != null && addressLine2.length() > 100) {
            return "Address line 2 is too long.";
        }
        return null; // Valid
    }

    public String validateLandmark(String landmark) {
        if (landmark != null && landmark.length() > 100) {
            return "Landmark is too long.";
        }
        return null; // Valid
    }

    public String validateZipCode(String zipCode) {
        if (!StringUtils.hasText(zipCode)) {
            return "Zip code is required.";
        }
        String regex = "^[0-9]{5}(?:-[0-9]{4})?$"; // Validates US zip code format
        if (!zipCode.matches(regex)) {
            return "Invalid zip code format.";
        }
        return null; // Valid
    }

    public String validateCountry(String country) {
        if (!StringUtils.hasText(country)) {
            return "Country is required.";
        }

        // Check if the country exists in the database
        Optional<Location> location = locationService.getLocationByNameAndType(country, "Country");
        if (location.isEmpty()) {
            return "Invalid country.";
        }

        return null; // Valid
    }

    public String validateState(String state) {
        if (!StringUtils.hasText(state)) {
            return "State is required.";
        }

        Optional<Location> location = locationService.getLocationByNameAndTypeState(state, "state");
        if (location.isEmpty()) {
            return "Invalid State.";
        }

        return null; // Valid
    }

    public String validateAddressLine1(String addressLine1) {
        if (!StringUtils.hasText(addressLine1)) {
            return "Address line 1 is required.";
        }
        return null; // Valid
    }

    public  String validateCity(String city) {
        if (!StringUtils.hasText(city)) {
            return "City is required.";
        }

        Optional<Location> location = locationService.getLocationByNameAndTypeCity(city, "city");
        if (location.isEmpty()) {
            return "Invalid City.";
        }

        return null; // Valid
    }


}
