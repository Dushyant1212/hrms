package com.modulobytes.hrms_modulobytes.DTOs.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data

//@JsonInclude(JsonInclude.Include.NON_NULL)

public class SignupResponseDTO {


    private String firstName;

    private String middleName; // Optional, no validation use


    private String lastName;


    @Column(unique = true)
    private String email;


    @Column(unique = true)
    private String phoneNumber;


    private String dateOfBirth;


    private String password;

    //    @Transient // Not persisted in the database

    private String confirmPassword;
}
