package com.modulobytes.hrms_modulobytes.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "company_logo22")
@Getter
@Setter
public class CompanyLogo {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_path", columnDefinition = "LONGTEXT", nullable = false)
    private String filePath;

//    @OneToOne(mappedBy = "companyLogo")
//    @JsonIgnore
//    private CompanyOnboardingDetail companyOnboardingDetail;
}
