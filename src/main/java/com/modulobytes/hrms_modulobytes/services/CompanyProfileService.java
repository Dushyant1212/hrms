package com.modulobytes.hrms_modulobytes.services;

import com.modulobytes.hrms_modulobytes.DTOs.Request.UserProfileDTO;
import com.modulobytes.hrms_modulobytes.entity.CompanyLogo;
import com.modulobytes.hrms_modulobytes.entity.RegisterAddress;
import com.modulobytes.hrms_modulobytes.entity.User;
import com.modulobytes.hrms_modulobytes.entity.CompanyTaxDetails;
import com.modulobytes.hrms_modulobytes.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CompanyProfileService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TaxDetailsRepository userTaxDetailsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RegisterAddressRepository registerAddressRepository;

    @Autowired
    private CompanyOnboardingRepo companyOnboardingRepository;

    @Autowired
    private CompanyLogoRepository companyLogoRepository;


    public UserProfileDTO getUserProfile(Long id) {
        Optional<User> userOpt = userRepo.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();

            // Map User entity to UserProfileDTO
            UserProfileDTO userProfileDTO = modelMapper.map(user, UserProfileDTO.class);

            // Fetch and map other related entities
            CompanyTaxDetails taxDetails = userTaxDetailsRepository.findById(id).orElse(new CompanyTaxDetails());
            RegisterAddress address = registerAddressRepository.findById(id).orElse(new RegisterAddress());
            CompanyLogo logo = companyLogoRepository.findById(id).orElse(new CompanyLogo());

            userProfileDTO.setTaxDetails(taxDetails);
            userProfileDTO.setRegisterAddress(address);
            userProfileDTO.setCompanyLogo(logo);

            return userProfileDTO;
        } else {
            return null; // Handle user not found
        }
    }


//    public UserProfileDTO getUserProfile(Long id) { // Only one parameter now
//        Optional<User> userOpt = userRepo.findById(id);
//        if (userOpt.isPresent()) {
//            User user = userOpt.get();
//            UserTaxDetails taxDetails = userTaxDetailsRepository.findById(id).orElse(null);
//            Optional<RegisterAddress> address = registerAddressRepository.findById(id);
//            System.out.println("Register Address: " + address);
//
//            // Assemble the DTO
//            UserProfileDTO userProfileDTO = new UserProfileDTO();
//            //userProfileDTO.setUserId(user.getId());
//            userProfileDTO.setFirstName(user.getFirstName());
//            userProfileDTO.setMiddleName(user.getMiddleName());
//            userProfileDTO.setLastName(user.getLastName());
//            userProfileDTO.setEmail(user.getEmail());
//            userProfileDTO.setPhoneNumber(user.getPhoneNumber());
//            userProfileDTO.setDateOfBirth(user.getDateOfBirth());
//            userProfileDTO.setTaxDetails(taxDetails != null ? taxDetails : new UserTaxDetails());
//            userProfileDTO.setRegisterAddress(address.orElse(new RegisterAddress())); // Use `orElse` to avoid null
//
//            return userProfileDTO;
//        } else {
//            return null; // Handle user not found
//        }
//
//    }


//    public UserProfileDTO getUserProfile(Long userId,Long id) {
//        Optional<User> userOpt = userRepo.findById(userId);
//        if (userOpt.isPresent()) {
//            User user = userOpt.get();
//            UserTaxDetails taxDetails = userTaxDetailsRepository.findById(userId).orElse(null);
//            //RegisterAddress address = registerAddressRepository.findById();
//            Optional<RegisterAddress> address=registerAddressRepository.findById(id);
//            System.out.println("Register Address: " + address);
//
//            // If no address exists, create a new RegisterAddress with default values
////            if (address == null) {
////                address = new RegisterAddress();
////                address.setId(address.getId());
////                address.setAddressLine1(address.getAddressLine1());
////                address.setAddressLine2("7ughj");
////                address.setLandmark("");
////                address.setZipCode("");
////                address.setCountry("");
////                address.setState("");
////                address.setCity("");
//////                address.setUser(user);
////            }
//
//            // Assemble the DTO
//            UserProfileDTO userProfileDTO = new UserProfileDTO();
//            userProfileDTO.setUserId(user.getId());
//            userProfileDTO.setFirstName(user.getFirstName());
//            userProfileDTO.setMiddleName(user.getMiddleName());
//            userProfileDTO.setLastName(user.getLastName());
//            userProfileDTO.setEmail(user.getEmail());
//            userProfileDTO.setPhoneNumber(user.getPhoneNumber());
//            userProfileDTO.setDateOfBirth(user.getDateOfBirth());
//            userProfileDTO.setTaxDetails(taxDetails != null ? taxDetails : new UserTaxDetails());
//            //userProfileDTO.setRegisterAddress(address);
//            userProfileDTO.setRegisterAddress(address !=null ? address : new RegisterAddress());
//
//            return userProfileDTO;
//        } else {
//            return null; // Handle user not found
//        }
//    }

}


