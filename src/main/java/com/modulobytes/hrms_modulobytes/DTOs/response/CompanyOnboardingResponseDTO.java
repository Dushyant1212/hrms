package com.modulobytes.hrms_modulobytes.DTOs.response;

import com.modulobytes.hrms_modulobytes.entity.RegisterAddress;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyOnboardingResponseDTO {

    private String companyName;

    private String companyWebsite;

    private String companySize;


    private RegisterAddress registeredAddress;


//    private String corporateAddress;


    private String industryType;


//    private String companyLogo;
}
