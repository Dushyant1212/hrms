package com.modulobytes.hrms_modulobytes.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Users8")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String middleName; // Optional, no validation use


    private String lastName;

    @Column(unique = true)
    private String email;


    @Column(unique = true)
    private String phoneNumber;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy") ///..... entity use..
    ///18 + use ... today ...validate //create date and change date...
    private String dateOfBirth;


    private String password;

//    @Transient // Not persisted in the database

    private String confirmPassword;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<RegisterAddress> addresses;

}
/*
{
    "firstName": "dushyant",
    "middleName": "",
    "lastName": "puri",
    "email": "dushyant@email.com",
    "phoneNumber": "1234567890",
    "dateOfBirth": "1995-01-01",
    "password": "12341234",
    "confirmPassword": "12341234"
}
 */