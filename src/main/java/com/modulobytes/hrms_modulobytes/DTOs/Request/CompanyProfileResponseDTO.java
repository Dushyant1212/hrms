package com.modulobytes.hrms_modulobytes.DTOs.Request;

import com.modulobytes.hrms_modulobytes.entity.CompanyTaxDetails;
import com.modulobytes.hrms_modulobytes.entity.RegisterAddress;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyProfileResponseDTO {

    private String companyName;
    private String companyWebsite;
    private String companySize;
    private String industryType;
    private RegisterAddress registeredAddress;
    private CompanyTaxDetails taxDetails;
    private String logoBase64; // Base64 encoded logo
}
