package com.modulobytes.hrms_modulobytes.DTOs.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisteredAddressResponseDTO {
    private String addressLine2;
    private String landmark;
    private String zipCode;
    private String country;
    private String state;
    private String city;
    private Long userId;
}
