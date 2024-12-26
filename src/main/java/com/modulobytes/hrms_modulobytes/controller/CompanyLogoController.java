package com.modulobytes.hrms_modulobytes.controller;

import com.modulobytes.hrms_modulobytes.services.CompanyLogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/logos")
public class CompanyLogoController {
    @Autowired
    private CompanyLogoService companyLogoService;

//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadLogo(@RequestParam("file") MultipartFile file) {
//        try {
//            companyLogoService.storeLogo(file);
//            return new ResponseEntity<>("Logo uploaded successfully!", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Error uploading logo: " + e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }



    @PostMapping("/uploadLogo")
    public ResponseEntity<String> uploadLogo(@RequestParam("file") MultipartFile file) {
        try {
            companyLogoService.storeLogo(file);
            return ResponseEntity.ok("Logo uploaded successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Validation Error: " + e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading logo.");
        }
    }
}
