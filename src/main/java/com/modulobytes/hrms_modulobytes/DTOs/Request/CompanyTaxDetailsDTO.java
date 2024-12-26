package com.modulobytes.hrms_modulobytes.DTOs.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyTaxDetailsDTO {
    private String panNumber;
    private String tanNumber;
    private String gstNumber;
    private String professionalTaxState;
    private String crcNumber;
    private String msmeRegistrationNumber;
    private String professionalTaxRegistrationNumber;
}
