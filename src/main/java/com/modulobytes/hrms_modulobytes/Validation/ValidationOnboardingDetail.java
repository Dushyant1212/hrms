package com.modulobytes.hrms_modulobytes.Validation;

import com.modulobytes.hrms_modulobytes.entity.Location;
import com.modulobytes.hrms_modulobytes.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Component
public class ValidationOnboardingDetail {
    @Autowired
    public static LocationService locationService;

    public ValidationOnboardingDetail(LocationService locationService) {
        ValidationOnboardingDetail.locationService = locationService;
    }

    public static String validateCompanyName(String companyName) {
        if (!StringUtils.hasText(companyName)) {
            return "Company name is required.";
        }
        return null; // Valid
    }

    // Validate Registered Address



    public static String validateCompanyWebsite(String companyWebsite) {
        String regex = "^(http(s)?://)?(www\\.)?[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}(/.*)?$";
        if (!companyWebsite.matches(regex)) {
            return "Invalid website URL format.";
        }
        return null; // Valid
    }

    // Validate Company Size
    public static String validateCompanySize(String companySize) {
        if (!StringUtils.hasText(companySize)) {
            return "Company size is required.";
        }
        String regex = "^(0-50|51-100|101-200|201-400|401-500|500\\+)$";
        if (!companySize.matches(regex)) {
            return "Invalid company size. Allowed values: 0-50, 51-100, 101-200, 201-400, 401-500, 500+.";
        }
        return null; // Valid
    }





}
