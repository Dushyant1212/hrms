package com.modulobytes.hrms_modulobytes.controller;

import com.modulobytes.hrms_modulobytes.DTOs.Request.UserProfileDTO;
import com.modulobytes.hrms_modulobytes.services.CompanyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserProfileController {
    @Autowired
    private CompanyProfileService companyProfileService;

    // Get user profile by user ID
//    @GetMapping("/profile/{userId}/{id}") // Define both userId and id in the URL path
//    public UserProfileDTO getUserProfile(@PathVariable Long userId, @PathVariable Long id) {
//        return userProfileService.getUserProfile(userId, id); // Pass both userId and id to the service
//    }

    @GetMapping("/profile/{id}") // Only passing one 'id'
    public UserProfileDTO getUserProfile(@PathVariable Long id) {
        return companyProfileService.getUserProfile(id); // Pass only 'id' to the service
    }
}
