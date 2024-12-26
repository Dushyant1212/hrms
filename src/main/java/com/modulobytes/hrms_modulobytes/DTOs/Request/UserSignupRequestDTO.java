package com.modulobytes.hrms_modulobytes.DTOs.Request;
import jakarta.persistence.Column;
import lombok.Data;
@Data
public class UserSignupRequestDTO {

        private String firstName; /////.....

        private String middleName; // Optional, no validation use

        private String lastName;

        @Column(unique = true)
        private String email;

        @Column(unique = true)
        private String phoneNumber;


        private String dateOfBirth;


        private String password;

        //@Transient // Not persisted in the database
        private String confirmPassword;
    }

