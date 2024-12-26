package com.modulobytes.hrms_modulobytes.services;
import com.modulobytes.hrms_modulobytes.DTOs.Request.CompanyOnboardingRequestDTO;
import com.modulobytes.hrms_modulobytes.DTOs.Request.RegisteredAddressRequestDTO;
import com.modulobytes.hrms_modulobytes.entity.CompanyOnboardingDetail;
import com.modulobytes.hrms_modulobytes.entity.RegisterAddress;
import com.modulobytes.hrms_modulobytes.repository.CompanyLogoRepository;
import com.modulobytes.hrms_modulobytes.repository.CompanyOnboardingRepo;
import com.modulobytes.hrms_modulobytes.repository.RegisterAddressRepository;
import com.modulobytes.hrms_modulobytes.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;


@Service

public class CompanyOnboardingService {
    private final CompanyOnboardingRepo companyOnboardingRepo;
    private final RegisterAddressRepository registerAddressRepository;
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;
    private final CompanyLogoRepository companyLogoRepository;

    public CompanyOnboardingService(CompanyOnboardingRepo companyOnboardingRepo, RegisterAddressRepository registerAddressRepository, ModelMapper modelMapper, UserRepo userRepo, CompanyLogoRepository companyLogoRepository) {
        this.companyOnboardingRepo = companyOnboardingRepo;
        this.registerAddressRepository = registerAddressRepository;
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
        this.companyLogoRepository = companyLogoRepository;
    }






//    public CompanyOnboardingDetail findById(Long companyId) {
//        Optional<CompanyOnboardingDetail> company = companyOnboardingRepo.findById(companyId);
//        return company.orElse(null);
//    }
//
//    public CompanyOnboardingDetail saveCompanyDetails(CompanyOnboardingDetail companyOnboardingDetail) {
//        return companyOnboardingRepo.save(companyOnboardingDetail);
//    }
//
//    public CompanyLogo saveCompanyLogo(CompanyLogo companyLogo) {
//        return companyLogoRepository.save(companyLogo);
//    }





//    public void saveCompanyDetails(CompanyOnboardingDetail companyDetails) {
//        companyOnboardingRepo.save(companyDetails);
//    }
//
//    public CompanyOnboardingDetail findById(Long id) {
//        return companyOnboardingRepo.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Company not found with ID: " + id));
//    }



//    public CompanyOnboardingDetail findById(Long id) {
//        return companyOnboardingRepo.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Company not found with ID: " + id));
//    }

//    public CompanyOnboardingDetail saveCompanyDetailsWithLogo(CompanyOnboardingRequestDTO companyOnboardingDTO, byte[] logoData) {
//        // Save the logo to the CompanyLogo table
//        CompanyLogo companyLogo = new CompanyLogo();
//        companyLogo.setLogo(logoData);
//        companyLogo = companyLogoRepository.save(companyLogo);
//
//        // Save the company details
//        CompanyOnboardingDetail companyOnboardingDetail = new CompanyOnboardingDetail();
//        companyOnboardingDetail.setCompanyName(companyOnboardingDTO.getCompanyName());
//        companyOnboardingDetail.setCompanyWebsite(companyOnboardingDTO.getCompanyWebsite());
//        companyOnboardingDetail.setCompanySize(companyOnboardingDTO.getCompanySize());
//        companyOnboardingDetail.setIndustryType(companyOnboardingDTO.getIndustryType());
//
//        // Link the logo to the company
//        companyOnboardingDetail.setCompanyLogo(companyLogo);
//
//        // Save and return company onboarding details
//        return companyOnboardingRepo.save(companyOnboardingDetail);
//    }



    // Save company details
    @Transactional
    public CompanyOnboardingDetail saveCompanyDetails(CompanyOnboardingRequestDTO companyOnboardingRequestDTO) {
        // Map the DTO to entity using ModelMapper
        CompanyOnboardingDetail companyOnboardingDetail = modelMapper.map(companyOnboardingRequestDTO, CompanyOnboardingDetail.class);
        //companyOnboardingDetail.setRegisteredAddress(registerAddress);

        // Save the company details
        return companyOnboardingRepo.save(companyOnboardingDetail);
    }

    // Save the registered address
    public RegisterAddress saveRegisterAddress(RegisteredAddressRequestDTO registerAddressDTO) {
//        // Find the user
//        User user = userRepo.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("User ID does not exist."));

        // Map the DTO to entity
        RegisterAddress registerAddress = modelMapper.map(registerAddressDTO, RegisterAddress.class);
        //registerAddress.setUser(user); // Set the User object

        // Save the register address
        return registerAddressRepository.save(registerAddress);

    }


}



