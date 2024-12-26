package com.modulobytes.hrms_modulobytes.DTOs.Request;

import com.modulobytes.hrms_modulobytes.entity.CompanyLogo;
import com.modulobytes.hrms_modulobytes.entity.RegisterAddress;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyOnboardingRequestDTO {
//    @NotNull
//    private Long userId;

//    private Integer version;


    private String companyName;

    private String companyWebsite;


    private String companySize;


//    private RegisteredAddressRequestDTO registeredAddress;
    //private CompanyLogo companyLogo;

//    private String corporateAddress;
    private String industryType;





//    private String companyLogo;


}
