package com.modulobytes.hrms_modulobytes.DTOs.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisteredAddressRequestDTO {

    private String addressLine1;

    private String addressLine2;

    private String landmark;

    private String zipCode;

    private String country;

    private String state;

    private String city;

   // private Long userId;
}
