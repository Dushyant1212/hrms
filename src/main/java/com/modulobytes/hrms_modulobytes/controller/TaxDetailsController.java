package com.modulobytes.hrms_modulobytes.controller;

import com.modulobytes.hrms_modulobytes.DTOs.Request.CompanyTaxDetailsDTO;
import com.modulobytes.hrms_modulobytes.services.TaxDetailsValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tax-details")
public class TaxDetailsController {
    // POST endpoint to submit tax details
    @Autowired
    private TaxDetailsValidationService taxDetailsValidationService;

    // POST endpoint to submit tax details and save in the database
    @PostMapping("/submit")
    public String submitTaxDetails(@RequestBody CompanyTaxDetailsDTO companyTaxDetailsDTO) {
        String message = taxDetailsValidationService.saveTaxDetails(companyTaxDetailsDTO);
        return message;
    }
}

