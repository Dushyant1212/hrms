package com.modulobytes.hrms_modulobytes.DTOs.Request;

import com.modulobytes.hrms_modulobytes.entity.CompanyLogo;
import com.modulobytes.hrms_modulobytes.entity.RegisterAddress;
import com.modulobytes.hrms_modulobytes.entity.CompanyTaxDetails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileDTO {
//    private Long userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String dateOfBirth;
    private CompanyTaxDetails taxDetails;
    private RegisterAddress registerAddress;
    private CompanyLogo companyLogo;
//    private CompanyOnboardingDetail companyOnboardingDetail;
}
