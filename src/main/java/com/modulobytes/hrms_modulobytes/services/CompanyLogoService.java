package com.modulobytes.hrms_modulobytes.services;

import com.modulobytes.hrms_modulobytes.Validation.CompanyLogoValidation;
import com.modulobytes.hrms_modulobytes.entity.CompanyLogo;

import com.modulobytes.hrms_modulobytes.repository.CompanyLogoRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.Base64;

@Service
public class CompanyLogoService {

    private final CompanyLogoRepository companyLogoRepository;

    @Value("${logo.upload.dir}")
    private String uploadDir;  // This is Spring's @Value annotation for property injection

    public CompanyLogoService(CompanyLogoRepository companyLogoRepository) {
        this.companyLogoRepository = companyLogoRepository;
    }

//    public void storeLogo(MultipartFile file) throws IOException {
//        // Ensure the directory exists
//        File directory = new File(uploadDir);
//        if (!directory.exists()) {
//            directory.mkdirs();
//        }
//
//        // Get the file's original name and construct the path
//        String fileName = file.getOriginalFilename();
//        Path path = Paths.get(uploadDir + File.separator + fileName);
//
//        // Save the file to the constructed path
//        Files.copy(file.getInputStream(), path);
//
//        // Save the file path in the database
//        CompanyLogo companyLogo = new CompanyLogo();
//        companyLogo.setFilePath(path.toString()); // Save absolute path
//        // Save the object to the database using repository (ensure repository is injected)
//        companyLogoRepository.save(companyLogo); // Replace with actual repository instance
//    }

    public void storeLogo(MultipartFile file) throws IOException {
        // Validate the logo file
        CompanyLogoValidation.validate(file);

        // Convert file to Base64
        byte[] fileBytes = file.getBytes();
        String base64EncodedFile = Base64.getEncoder().encodeToString(fileBytes);

        // Save Base64 string to database
        CompanyLogo companyLogo = new CompanyLogo();
        companyLogo.setFilePath(base64EncodedFile);
        companyLogoRepository.save(companyLogo);
    }

}
