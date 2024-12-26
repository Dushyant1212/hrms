package com.modulobytes.hrms_modulobytes.services;

import com.modulobytes.hrms_modulobytes.DTOs.Request.CompanyTaxDetailsDTO;
import com.modulobytes.hrms_modulobytes.entity.CompanyTaxDetails;
import com.modulobytes.hrms_modulobytes.repository.TaxDetailsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class TaxDetailsValidationService {

    private static final List<String> VALID_STATES = Arrays.asList("Maharashtra", "Karnataka", "Tamil Nadu"); // List of states for Professional Tax
    //private static final String VALID_STATES = "http://localhost:8080/api/locations/states/india";
    //private static final List<Location> validState =
    @Autowired
    private TaxDetailsRepository taxDetailsRepository;

    @Autowired
    private ModelMapper modelMapper;




    // Validate PAN number (10 characters, alphanumeric, and unique)
    public String validatePanNumber(String panNumber) {
        if (panNumber == null || panNumber.length() != 10 || !panNumber.matches("[A-Z0-9]+")) {
            return "Invalid PAN number. It should be 10 characters and alphanumeric.";
        }
        if (taxDetailsRepository.existsByPanNumber(panNumber)) {
            return "PAN number already exists. It must be unique.";
        }
        return null;
    }

    // Validate TAN number (10 characters, alphanumeric, and unique)
    public String validateTanNumber(String tanNumber) {
        if (tanNumber == null || tanNumber.length() != 10 || !tanNumber.matches("[A-Z0-9]+")) {
            return "Invalid TAN number. It should be 10 characters and alphanumeric.";
        }
        if (taxDetailsRepository.existsByTanNumber(tanNumber)) {
            return "TAN number already exists. It must be unique.";
        }
        return null;
    }

    // Validate GST number (GST format: 15 characters, alphanumeric, and unique)
    public String validateGstNumber(String gstNumber) {
        if (gstNumber == null || gstNumber.length() != 15 || !gstNumber.matches("[A-Z0-9]+")) {
            return "Invalid GST number. It should be 15 characters and alphanumeric.";
        }
        if (taxDetailsRepository.existsByGstNumber(gstNumber)) {
            return "GST number already exists. It must be unique.";
        }
        return null;
    }

    // Validate CRC number (Alphanumeric and unique)
    public String validateCrcNumber(String crcNumber) {
        if (crcNumber == null || !crcNumber.matches("[A-Z0-9]+")) {
            return "Invalid CRC number. It should be alphanumeric.";
        }
        if (taxDetailsRepository.existsByCrcNumber(crcNumber)) {
            return "CRC number already exists. It must be unique.";
        }
        return null;
    }

    // Validate MSME Registration Number (Alphanumeric and unique)
    public String validateMsmeRegistrationNumber(String msmeRegistrationNumber) {
        if (msmeRegistrationNumber == null || !msmeRegistrationNumber.matches("[A-Z0-9]+")) {
            return "Invalid MSME Registration Number. It should be alphanumeric.";
        }
        if (taxDetailsRepository.existsByMsmeRegistrationNumber(msmeRegistrationNumber)) {
            return "MSME Registration Number already exists. It must be unique.";
        }
        return null;
    }

    // Validate Professional Tax Registration Number (Alphanumeric and unique)
    public String validateProfessionalTaxRegistrationNumber(String professionalTaxRegistrationNumber) {
        if (professionalTaxRegistrationNumber == null || !professionalTaxRegistrationNumber.matches("[A-Z0-9]+")) {
            return "Invalid Professional Tax Registration Number. It should be alphanumeric.";
        }
        if (taxDetailsRepository.existsByProfessionalTaxRegistrationNumber(professionalTaxRegistrationNumber)) {
            return "Professional Tax Registration Number already exists. It must be unique.";
        }
        return null;
    }

    // Validate Professional Tax State (State must be in valid list)
    public String validateProfessionalTaxState(String state) {
        if (state == null || !VALID_STATES.contains(state)) {
            return "Invalid Professional Tax State. Please select a valid state.";
        }
        return null;
    }

    // Save tax details after validation
    public String saveTaxDetails(CompanyTaxDetailsDTO taxDetailsDTO) {
        // Perform field validation
        String errorMessage = validatePanNumber(taxDetailsDTO.getPanNumber());
        if (errorMessage != null) return errorMessage;

        errorMessage = validateTanNumber(taxDetailsDTO.getTanNumber());
        if (errorMessage != null) return errorMessage;

        errorMessage = validateGstNumber(taxDetailsDTO.getGstNumber());
        if (errorMessage != null) return errorMessage;

        errorMessage = validateCrcNumber(taxDetailsDTO.getCrcNumber());
        if (errorMessage != null) return errorMessage;

        errorMessage = validateMsmeRegistrationNumber(taxDetailsDTO.getMsmeRegistrationNumber());
        if (errorMessage != null) return errorMessage;

        errorMessage = validateProfessionalTaxRegistrationNumber(taxDetailsDTO.getProfessionalTaxRegistrationNumber());
        if (errorMessage != null) return errorMessage;

        errorMessage = validateProfessionalTaxState(taxDetailsDTO.getProfessionalTaxState());
        if (errorMessage != null) return errorMessage;

        // Map DTO to Entity using ModelMapper
        CompanyTaxDetails taxDetails = modelMapper.map(taxDetailsDTO, CompanyTaxDetails.class);

        // Save the valid tax details to the database
        taxDetailsRepository.save(taxDetails);

        return "Tax details saved successfully!";
    }
}
