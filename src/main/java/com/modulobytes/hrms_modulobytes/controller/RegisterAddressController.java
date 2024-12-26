package com.modulobytes.hrms_modulobytes.controller;

import com.modulobytes.hrms_modulobytes.DTOs.Request.RegisteredAddressRequestDTO;
import com.modulobytes.hrms_modulobytes.Validation.RegisterAddressValidation;
import com.modulobytes.hrms_modulobytes.Validation.ValidationOnboardingDetail;
import com.modulobytes.hrms_modulobytes.entity.RegisterAddress;
import com.modulobytes.hrms_modulobytes.services.RegisterAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

@RestController
@RequestMapping("/address")
public class RegisterAddressController {
//    private final RegisteredAddressRequestDTO registeredAddressRequestDTO;
    private final RegisterAddressService registerAddressService;
    private final RegisterAddressValidation registerAddressValidation;

    public RegisterAddressController(RegisterAddressService registerAddressService, RegisterAddressValidation registerAddressValidation) {

        this.registerAddressService = registerAddressService;
        this.registerAddressValidation = registerAddressValidation;
    }


//    @PostMapping("/save")
//    public ResponseEntity<?> saveRegisterAddress(@RequestBody RegisteredAddressRequestDTO registeredAddressRequestDTO) {
//
////        String AddressLine1Validation = RegisterAddressValidation.validateAddressLine1(companyOnboardingRequestDTO.getRegisteredAddress().getAddressLine1());
////        if(AddressLine1Validation != null){
////            return ResponseEntity.badRequest().body(AddressLine1Validation);
////        }
//        String AddressLine1Validation = RegisterAddressValidation.validateAddressLine1(registeredAddressRequestDTO.getAddressLine1());
//        if(AddressLine1Validation != null){
//            return ResponseEntity.badRequest().body(AddressLine1Validation);
//        }
//
//        String AddressLine2Validation = RegisterAddressValidation.validateAddressLine2(registeredAddressRequestDTO.getAddressLine2());
//        if(AddressLine2Validation!=null){
//            return ResponseEntity.badRequest().body(AddressLine2Validation);
//        }
//
//        String LandmarkValidation = RegisterAddressValidation.validateLandmark(registeredAddressRequestDTO.getLandmark());
//        if(LandmarkValidation!=null){
//            return ResponseEntity.badRequest().body(LandmarkValidation);
//        }
//        // Validate ZipCode (assuming you want to validate this as well)
//        String zipCodeValidation = RegisterAddressValidation.validateZipCode(registeredAddressRequestDTO.getZipCode());
//        if (zipCodeValidation != null) {
//            return ResponseEntity.badRequest().body(zipCodeValidation);
//        }
//
//// Validate Country (assuming you want to validate this as well)
//        String countryValidation = RegisterAddressValidation.validateCountry(registeredAddressRequestDTO.getCountry());
//        if (countryValidation != null) {
//            return ResponseEntity.badRequest().body(countryValidation);
//        }
//
//// Validate State (assuming you want to validate this as well)
//        String stateValidation = RegisterAddressValidation.validateState(registeredAddressRequestDTO.getState());
//        if (stateValidation != null) {
//            return ResponseEntity.badRequest().body(stateValidation);
//        }
//
//// Validate City (assuming you want to validate this as well)
//        String cityValidation = RegisterAddressValidation.validateCity(registeredAddressRequestDTO.getCity());
//        if (cityValidation != null) {
//            return ResponseEntity.badRequest().body(cityValidation);
//        }
//
//
//
//
////        String AddressLine2Validation = ValidationOnboardingDetail.validateAddressLine2(companyOnboardingRequestDTO.getRegisteredAddress().getAddressLine2());
//
////
////
////
////        String ZipCodeValidation = ValidationOnboardingDetail.validateZipCode(companyOnboardingRequestDTO.getRegisteredAddress().getZipCode());
////        if(ZipCodeValidation != null){
////            return ResponseEntity.badRequest().body(ZipCodeValidation);
////        }
////        String CountryValidation = ValidationOnboardingDetail.validateCountry(companyOnboardingRequestDTO.getRegisteredAddress().getCountry());
////        if(CountryValidation != null){
////            return ResponseEntity.badRequest().body(CountryValidation);
////        }
////
////        String StateValidation = ValidationOnboardingDetail.validateState(companyOnboardingRequestDTO.getRegisteredAddress().getState());
////        if(StateValidation != null){
////            return ResponseEntity.badRequest().body(StateValidation);
////        }
////
////
////        String CityValidation = ValidationOnboardingDetail.validateCity(companyOnboardingRequestDTO.getRegisteredAddress().getCity());
////        if(CityValidation !=null){
////            return ResponseEntity.badRequest().body(CityValidation);
////        }
////
////         //Validate country
////        String countryValidation = ValidationOnboardingDetail.validateCountry(companyOnboardingRequestDTO.getRegisteredAddress().getCountry());
////        if (countryValidation != null) {
////            return ResponseEntity.badRequest().body(countryValidation);
////        }
////
////        // Validate state
////        String stateValidation = ValidationOnboardingDetail.validateState(
////                companyOnboardingRequestDTO.getRegisteredAddress().getCountry(),
////                companyOnboardingRequestDTO.getRegisteredAddress().getState()
////        );
////        if (stateValidation != null) {
////            return ResponseEntity.badRequest().body(stateValidation);
////        }
////
////        // Validate city
////        String cityValidation = ValidationOnboardingDetail.validateCity(
////                companyOnboardingRequestDTO.getRegisteredAddress().getState(),
////                companyOnboardingRequestDTO.getRegisteredAddress().getCity()
////        );
////        if (cityValidation != null) {
////            return ResponseEntity.badRequest().body(cityValidation);
////        }
//
//
//        try {
//            // Create and save RegisterAddress entity
//            RegisterAddress registerAddress = new RegisterAddress();
//            registerAddress.setAddressLine1(registeredAddressRequestDTO.getAddressLine1());
//            registerAddress.setAddressLine2(registeredAddressRequestDTO.getAddressLine2());
//            registerAddress.setLandmark(registeredAddressRequestDTO.getLandmark());
//            registerAddress.setZipCode(registeredAddressRequestDTO.getZipCode());
//            registerAddress.setCountry(registeredAddressRequestDTO.getCountry());
//            registerAddress.setState(registeredAddressRequestDTO.getState());
//            registerAddress.setCity(registeredAddressRequestDTO.getCity());
//
//            registerAddressService.saveRegisterAddress(registerAddress);
//
//            return ResponseEntity.ok("Address saved successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error saving address: " + e.getMessage());
//        }

    @PostMapping("/save")
    public ResponseEntity<?> saveRegisterAddress(@RequestBody RegisteredAddressRequestDTO registeredAddressRequestDTO) {

        String AddressLine1Validation = registerAddressValidation.validateAddressLine1(registeredAddressRequestDTO.getAddressLine1());
        if (AddressLine1Validation != null) {
            return ResponseEntity.badRequest().body(AddressLine1Validation);
        }

        String AddressLine2Validation = registerAddressValidation.validateAddressLine2(registeredAddressRequestDTO.getAddressLine2());
        if (AddressLine2Validation != null) {
            return ResponseEntity.badRequest().body(AddressLine2Validation);
        }

        String LandmarkValidation = registerAddressValidation.validateLandmark(registeredAddressRequestDTO.getLandmark());
        if (LandmarkValidation != null) {
            return ResponseEntity.badRequest().body(LandmarkValidation);
        }

        String zipCodeValidation = registerAddressValidation.validateZipCode(registeredAddressRequestDTO.getZipCode());
        if (zipCodeValidation != null) {
            return ResponseEntity.badRequest().body(zipCodeValidation);
        }

        String countryValidation = registerAddressValidation.validateCountry(registeredAddressRequestDTO.getCountry());
        if (countryValidation != null) {
            return ResponseEntity.badRequest().body(countryValidation);
        }

        String stateValidation = registerAddressValidation.validateState(registeredAddressRequestDTO.getState());
        if (stateValidation != null) {
            return ResponseEntity.badRequest().body(stateValidation);
        }

        String cityValidation = registerAddressValidation.validateCity(registeredAddressRequestDTO.getCity());
        if (cityValidation != null) {
            return ResponseEntity.badRequest().body(cityValidation);
        }

        try {
            RegisterAddress registerAddress = new RegisterAddress();
            registerAddress.setAddressLine1(registeredAddressRequestDTO.getAddressLine1());
            registerAddress.setAddressLine2(registeredAddressRequestDTO.getAddressLine2());
            registerAddress.setLandmark(registeredAddressRequestDTO.getLandmark());
            registerAddress.setZipCode(registeredAddressRequestDTO.getZipCode());
            registerAddress.setCountry(registeredAddressRequestDTO.getCountry());
            registerAddress.setState(registeredAddressRequestDTO.getState());
            registerAddress.setCity(registeredAddressRequestDTO.getCity());

            registerAddressService.saveRegisterAddress(registerAddress);

            return ResponseEntity.ok("Address saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving address: " + e.getMessage());
        }

    }

}

