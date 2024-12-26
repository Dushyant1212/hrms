package com.modulobytes.hrms_modulobytes.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "company_onboarding_new23")
@Getter
@Setter
public class CompanyOnboardingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // The auto-generated companyId

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "company_website", nullable = false)
    private String companyWebsite;

    @Column(name = "company_size", nullable = false)
    private String companySize;

//    @ManyToOne
//    @JoinColumn(name = "registered_address_id")  // Foreign key to RegisterAddress
//    private RegisterAddress registeredAddress;

    @Column(name = "industry_type", nullable = false)
    private String industryType;

//    @OneToOne(cascade = CascadeType.ALL) // Company logo relationship
//    @JoinColumn(name = "company_logo_id", referencedColumnName = "id")
//    private CompanyLogo companyLogo;
//
//    @OneToOne(cascade = CascadeType.ALL) // Tax details relationship
//    @JoinColumn(name = "tax_details_id", referencedColumnName = "id")
//    private CompanyTaxDetails companyTaxDetails;


}