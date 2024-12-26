package com.modulobytes.hrms_modulobytes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tax_details22")
@Getter
@Setter
public class CompanyTaxDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pan_number", nullable = false)
    private String panNumber;

    @Column(name = "tan_number", nullable = false)
    private String tanNumber;

    @Column(name = "gst_number", nullable = false)
    private String gstNumber;

    @Column(name = "crc_number", nullable = false)
    private String crcNumber;

    @Column(name = "msme_registration_number", nullable = false)
    private String msmeRegistrationNumber;

    @Column(name = "professional_tax_registration_number", nullable = false)
    private String professionalTaxRegistrationNumber;

    @Column(name = "professional_tax_state", nullable = false)
    private String professionalTaxState;

//    @OneToOne(mappedBy = "companyTaxDetails")
//    @JsonIgnore
//    private CompanyOnboardingDetail companyOnboardingDetail;
}