package com.modulobytes.hrms_modulobytes.controller;
import com.modulobytes.hrms_modulobytes.DTOs.Request.CompanyOnboardingRequestDTO;
import com.modulobytes.hrms_modulobytes.Validation.ValidationOnboardingDetail;
import com.modulobytes.hrms_modulobytes.entity.CompanyLogo;
import com.modulobytes.hrms_modulobytes.entity.CompanyOnboardingDetail;
import com.modulobytes.hrms_modulobytes.entity.RegisterAddress;
import com.modulobytes.hrms_modulobytes.services.CompanyOnboardingService;
import com.modulobytes.hrms_modulobytes.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

@RestController
@RequestMapping("/company")
public class CompanyOnboardingController {
    private final CompanyOnboardingService companyOnboardingService;
    //private final UserService userService;

    public CompanyOnboardingController(CompanyOnboardingService companyOnboardingService) {
        this.companyOnboardingService = companyOnboardingService;

    }

//    @PostMapping("/upload-logo")
//    public ResponseEntity<?> uploadLogo(@RequestParam("logo") MultipartFile logoFile, @RequestParam("companyId") Long companyId) {
//        try {
//            if (logoFile.isEmpty()) {
//                return ResponseEntity.badRequest().body("Logo file is required.");
//            }
//
//            // Define the file upload path
//            String uploadDir = "src/main/resources/static/Logo/";
//            String fileName = System.currentTimeMillis() + "_" + logoFile.getOriginalFilename();
//            String filePath = uploadDir + fileName;
//
//            // Ensure directory exists
//            File directory = new File(uploadDir);
//            if (!directory.exists()) {
//                directory.mkdirs();
//            }
//
//            // Save file
//            logoFile.transferTo(new File(filePath));
//
//            // Fetch company details and update logo path
//            CompanyOnboardingDetail company = companyOnboardingService.findById(companyId);
//            if (company == null) {
//                return ResponseEntity.badRequest().body("Invalid company ID.");
//            }
//
//            // Create and associate the company logo
//            CompanyLogo companyLogo = new CompanyLogo();
//            companyLogo.setFilePath(filePath);
//            companyOnboardingService.saveCompanyLogo(companyLogo);
//
//            // Associate the logo with the company onboarding details
//            company.setCompanyLogo(companyLogo);
//            companyOnboardingService.saveCompanyDetails(company);
//
//            return ResponseEntity.ok("Logo uploaded successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error uploading logo: " + e.getMessage());
//        }
//    }







//
//    @PostMapping("/upload-logo")
//    public ResponseEntity<?> uploadLogo(
//            @RequestParam("logo") MultipartFile logoFile,
//            @RequestParam("companyId") Long companyId) {
//        try {
//            if (logoFile == null || logoFile.isEmpty()) {
//                return ResponseEntity.badRequest().body("Logo file is required.");
//            }
//
//            // Define file upload path
//            String uploadDir = "src/main/resources/static/Logo/";
//            String fileName = System.currentTimeMillis() + "_" + logoFile.getOriginalFilename();
//            String filePath = uploadDir + fileName;
//
//            // Ensure directory exists
//            File directory = new File(uploadDir);
//            if (!directory.exists()) {
//                directory.mkdirs();
//            }
//
//            // Save file
//            logoFile.transferTo(new File(filePath));
//
//            // Fetch company details and update logo path
//            CompanyOnboardingDetail company = companyOnboardingService.findById(companyId);
//            if (company == null) {
//                return ResponseEntity.badRequest().body("Invalid company ID.");
//            }
//
//            CompanyLogo companyLogo = new CompanyLogo();
//            companyLogo.setFilePath(filePath);
//            company.setCompanyLogo(companyLogo);
//            companyOnboardingService.saveCompanyDetails(company);
//
//            return ResponseEntity.ok("Logo uploaded successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error uploading logo: " + e.getMessage());
//        }
//    }





//    @PostMapping("/upload-logo")
//    public ResponseEntity<?> uploadLogo(@RequestParam("logo") MultipartFile logoFile, @RequestParam("companyId") Long companyId) {
//        try {
//            if (logoFile.isEmpty()) {
//                return ResponseEntity.badRequest().body("Logo file is required.");
//            }
//
//            // Define the upload directory
//            String uploadDir = "src/main/resources/static/Logo/";
//            String fileName = System.currentTimeMillis() + "_" + logoFile.getOriginalFilename();
//            String filePath = uploadDir + fileName;
//
//            // Create the directory if it doesn't exist
//            File directory = new File(uploadDir);
//            if (!directory.exists()) {
//                directory.mkdirs();
//            }
//
//            // Save the file to the specified directory
//            logoFile.transferTo(new File(filePath));
//
//            // Find the company using the provided ID
//            CompanyOnboardingDetail company = companyOnboardingService.findById(companyId);
//            if (company == null) {
//                return ResponseEntity.badRequest().body("Invalid company ID.");
//            }
//
//            // Save the logo details
//            CompanyLogo companyLogo = new CompanyLogo();
//            companyLogo.setFilePath(filePath); // Save the relative path
//            company.setCompanyLogo(companyLogo);
//
//            // Save company details with the logo
//            companyOnboardingService.saveCompanyDetails(company);
//
//            return ResponseEntity.ok("Logo uploaded successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading logo: " + e.getMessage());
//        }
//    }



//    @PostMapping("/upload-logo")
//    public ResponseEntity<?> uploadLogo(@RequestParam("logo") MultipartFile logoFile, @RequestParam("companyId") Long companyId) {
//        try {
//            if (logoFile.isEmpty()) {
//                return ResponseEntity.badRequest().body("Logo file is required.");
//            }
//
//            String fileName = System.currentTimeMillis() + "_" + logoFile.getOriginalFilename();
//            String uploadDir = "logos/";
//            String filePath = uploadDir + fileName;
//
//            File directory = new File(uploadDir);
//            if (!directory.exists()) {
//                directory.mkdirs();
//            }
//            logoFile.transferTo(new File(filePath));
//
//            CompanyOnboardingDetail company = companyOnboardingService.findById(companyId);
//            if (company == null) {
//                return ResponseEntity.badRequest().body("Invalid company ID.");
//            }
//
//            CompanyLogo companyLogo = new CompanyLogo();
//            companyLogo.setFilePath(filePath);
//            company.setCompanyLogo(companyLogo);
//            companyOnboardingService.saveCompanyDetails(company);
//
//            return ResponseEntity.ok("Logo uploaded successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading logo: " + e.getMessage());
//        }
//    }


//
//    @PostMapping("/upload-logo")
//    public ResponseEntity<?> uploadLogo(@RequestParam("logo") MultipartFile logoFile, @RequestParam("companyId") Long companyId) {
//        try {
//            // Validate file
//            if (logoFile.isEmpty()) {
//                return ResponseEntity.badRequest().body("Logo file is required.");
//            }
//
//            // Generate file path
//            String fileName = System.currentTimeMillis() + "_" + logoFile.getOriginalFilename();
//            String uploadDir = "logos/";
//            String filePath = uploadDir + fileName;
//
//            // Save file to file system
//            File directory = new File(uploadDir);
//            if (!directory.exists()) {
//                directory.mkdirs();
//            }
//            logoFile.transferTo(new File(filePath));
//
//            // Update database with file path
//            CompanyOnboardingDetail company = companyOnboardingService.findById(companyId);
//            if (company == null) {
//                return ResponseEntity.badRequest().body("Invalid company ID.");
//            }
//
//            CompanyLogo companyLogo = new CompanyLogo();
//            companyLogo.setFilePath(filePath);
//            company.setCompanyLogo(companyLogo);
//            companyOnboardingService.saveCompanyDetails(company);
//
//            return ResponseEntity.ok("Logo uploaded successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading logo: " + e.getMessage());
//        }
//    }






//
//    @PostMapping("/onboard")
//    public ResponseEntity<?> onboardCompany(@RequestBody @Valid CompanyOnboardingRequestDTO companyOnboardingDTO,
//                                            @RequestParam Long userId) {
//        try {
//            // Validate user existence
//            if (!userService.existsById(userId)) {
//                return ResponseEntity.badRequest().body("Invalid user ID. User does not exist.");
//            }
//
//            // Validate company name
//            String companyNameValidation = ValidationOnboardingDetail.validateCompanyName(companyOnboardingDTO.getCompanyName());
//            if (companyNameValidation != null) {
//                return ResponseEntity.badRequest().body(companyNameValidation);
//            }
//
//            // Validate company website
//            String companyWebsiteValidation = ValidationOnboardingDetail.validateCompanyWebsite(companyOnboardingDTO.getCompanyWebsite());
//            if (companyWebsiteValidation != null) {
//                return ResponseEntity.badRequest().body(companyWebsiteValidation);
//            }
//
//            // Validate company size
//            String companySizeValidation = ValidationOnboardingDetail.validateCompanySize(companyOnboardingDTO.getCompanySize());
//            if (companySizeValidation != null) {
//                return ResponseEntity.badRequest().body(companySizeValidation);
//            }
//
//            // Validate registered address
//            RegisteredAddressRequestDTO registerAddressDTO = companyOnboardingDTO.getRegisteredAddress();
//            if (registerAddressDTO != null) {
//                String addressLine1Validation = ValidationOnboardingDetail.validateAddressLine1(registerAddressDTO.getAddressLine1());
//                if (addressLine1Validation != null) {
//                    return ResponseEntity.badRequest().body(addressLine1Validation);
//                }
//
//                String addressLine2Validation = ValidationOnboardingDetail.validateAddressLine2(registerAddressDTO.getAddressLine2());
//                if (addressLine2Validation != null) {
//                    return ResponseEntity.badRequest().body(addressLine2Validation);
//                }
//
//                String landmarkValidation = ValidationOnboardingDetail.validateLandmark(registerAddressDTO.getLandmark());
//                if (landmarkValidation != null) {
//                    return ResponseEntity.badRequest().body(landmarkValidation);
//                }
//
//                String zipCodeValidation = ValidationOnboardingDetail.validateZipCode(registerAddressDTO.getZipCode());
//                if (zipCodeValidation != null) {
//                    return ResponseEntity.badRequest().body(zipCodeValidation);
//                }
//
//                String countryValidation = ValidationOnboardingDetail.validateCountry(registerAddressDTO.getCountry());
//                if (countryValidation != null) {
//                    return ResponseEntity.badRequest().body(countryValidation);
//                }
//
//                String stateValidation = ValidationOnboardingDetail.validateState(registerAddressDTO.getState(), registerAddressDTO.getCity());
//                if (stateValidation != null) {
//                    return ResponseEntity.badRequest().body(stateValidation);
//                }
//
//                String cityValidation = ValidationOnboardingDetail.validateCity(registerAddressDTO.getCity(), registerAddressDTO.getState());
//                if (cityValidation != null) {
//                    return ResponseEntity.badRequest().body(cityValidation);
//                }
//            }
//
//            // Save the registered address
//            RegisterAddress registerAddress = companyOnboardingService.saveRegisterAddress(registerAddressDTO, userId);
//
//            // Save the company details
//            CompanyOnboardingDetail companyOnboardingDetail = companyOnboardingService.saveCompanyDetails(companyOnboardingDTO, registerAddress);
//
//            return ResponseEntity.ok().body("Company onboarded and address saved successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
//                    "status", "error",
//                    "message", "Error onboarding company: " + e.getMessage()
//            ));
//        }
//    }

//
//    @PostMapping("/onboard")
//    public ResponseEntity<?> onboardCompany(@RequestBody CompanyOnboardingRequestDTO companyOnboardingDTO,
//                                            @RequestBody RegisteredAddressRequestDTO registerAddressDTO,
//                                            @RequestParam(required = false) Long userId) {
//        try {
//            // Save registered address
//            RegisterAddress registerAddress = companyOnboardingService.saveRegisterAddress(registerAddressDTO, userId);
//
//            // Save company details
//            CompanyOnboardingDetail companyDetails = companyOnboardingService.saveCompanyDetails(companyOnboardingDTO, registerAddress);
//
//            return ResponseEntity.ok(companyDetails);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error: " + e.getMessage());
//        }
//    }

    @PostMapping("/detail")
    public ResponseEntity<?> onboardCompany(@RequestBody @Valid CompanyOnboardingRequestDTO companyOnboardingRequestDTO) {
        //Long userId = companyOnboardingRequestDTO.getUserId();  // Get the userId from the request body
//
//        if (userId == null) {
//            return ResponseEntity.badRequest().body("User ID is required for this operation.");
//        }

        // Validate user existence
//        if (!userService.existsById(userId)) {
//            return ResponseEntity.badRequest().body("Invalid user ID. User does not exist.");
//        }

        // Validate company name
        String CompanyNameValidation = ValidationOnboardingDetail.validateCompanyName(companyOnboardingRequestDTO.getCompanyName());
        if (CompanyNameValidation != null) {
            return ResponseEntity.badRequest().body(CompanyNameValidation);
        }
        // Validate company website
        String CompanyWebsiteValidation = ValidationOnboardingDetail.validateCompanyWebsite(companyOnboardingRequestDTO.getCompanyWebsite());
        if (CompanyWebsiteValidation != null) {
            return ResponseEntity.badRequest().body(CompanyWebsiteValidation);
        }
//
//        if (!companyOnboardingService.isCompanyWebsiteUnique(companyOnboardingRequestDTO.getCompanyWebsite())) {
//            return ResponseEntity.badRequest().body("The company website is already in use.");
//        }
        // Validate company size
        String CompanySizeValidation = ValidationOnboardingDetail.validateCompanySize(companyOnboardingRequestDTO.getCompanySize());
        if (CompanySizeValidation != null) {
            return ResponseEntity.badRequest().body(CompanySizeValidation);
        }


        try {
            // Save the company onboarding details (no address, logo, or other relationships)
            CompanyOnboardingDetail companyOnboardingDetail = companyOnboardingService.saveCompanyDetails(companyOnboardingRequestDTO);

            return ResponseEntity.ok().body("Company onboarded successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "error",
                    "message", "Error onboarding company: " + e.getMessage()
            ));
        }
    }
}




