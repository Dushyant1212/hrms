package com.modulobytes.hrms_modulobytes.controller;
import com.modulobytes.hrms_modulobytes.DTOs.Request.UserSignupRequestDTO;
import com.modulobytes.hrms_modulobytes.Validation.ValidationUser;
import com.modulobytes.hrms_modulobytes.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }




    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginRequest) {
        // Extract email and password from the request body
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        // Validate email format
        String emailValidationMessage = ValidationUser.validateEmail(email);
        if (emailValidationMessage != null) {
            return ResponseEntity.badRequest().body(emailValidationMessage);
        }

        String passwordValidationMessage = ValidationUser.validatePassword(password);
        if (passwordValidationMessage != null){
            return ResponseEntity.badRequest().body(passwordValidationMessage);
        }




        // Validate password presence
//        if (!StringUtils.hasText(password)) {
//            return ResponseEntity.badRequest().body("Password is required.");
//        }

        // Check if the user exists and the password matches using the service
        boolean isValidUser = userService.validateUser(email, password);
        if (!isValidUser) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
        }

        // Return success response
        return ResponseEntity.ok("Login successfully..");
    }






    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody UserSignupRequestDTO userSignupRequestDTO) {

        // Validate First Name..
        String firstNameValidation = ValidationUser.validateFirstName(userSignupRequestDTO.getFirstName());
        if (firstNameValidation != null) {
            return ResponseEntity.badRequest().body(firstNameValidation);
        }
        // Validate Last Name..
        String lastNameValidation = ValidationUser.validateLastName(userSignupRequestDTO.getLastName());
        if (lastNameValidation != null) {
            return ResponseEntity.badRequest().body(lastNameValidation);
        }

        // Validate Date of Birth..
        String dobValidation = ValidationUser.validateDateOfBirth(userSignupRequestDTO.getDateOfBirth());
        if (dobValidation != null) {
            return ResponseEntity.badRequest().body(dobValidation);
        }

        // Validate Password and Confirm Password..
        String passwordValidation = ValidationUser.validatePassword(
                userSignupRequestDTO.getPassword()
        );
        if (passwordValidation != null) {
            return ResponseEntity.badRequest().body(passwordValidation);
        }

        //phone Number Validation in Validation Class...
        String phoneNumberValidationMessage = ValidationUser.validatePhoneNumber(userSignupRequestDTO.getPhoneNumber());
        if (phoneNumberValidationMessage != null) {
           return ResponseEntity.badRequest().body(phoneNumberValidationMessage);// Return  error message
        }

        //Email Validation in Validation Class...
        String emailValidationMessage = ValidationUser.validateEmail(userSignupRequestDTO.getEmail());
        if (emailValidationMessage != null) {
            return ResponseEntity.badRequest().body(emailValidationMessage); // Return error message
        }


        try {
            //save User..
            userService.registerNewUser(userSignupRequestDTO);
            return ResponseEntity.ok("Signup successfully...");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }



}





//validater class use....
// Validate PhoneNumber format using regex..
//        String phoneRegex = "^\\\\+91[0-9]{10}$";
//        Pattern patternPhone =Pattern.compile(phoneRegex);
//        Matcher matcherPhone =patternPhone.matcher(signupRequestDTO.getPhoneNumber());
//        if(!matcherPhone.matches()){
//            // Check if the issue is due to length
//            if (!signupRequestDTO.getPhoneNumber().startsWith("+91")) {
//                return("Phone number must start with +91.");
//            } else if (signupRequestDTO.getPhoneNumber().length() != 13) { // 3 chars for +91 + 10 digits = 13
//                return("Phone number must have exactly 10 digits.");
//            }
//        }
// Validate email format using regex..
// emailRegex = ^[a-zA-Z0-9_+&*-]+(?:\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\.)+[a-zA-Z]{2,7}$  -----  "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(gmail\\.com|email\\.com)$
//        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@gmail\\.com$";
//        Pattern patternEmail = Pattern.compile(emailRegex);
//        Matcher matcherEmail = patternEmail.matcher(signupRequestDTO.getEmail());
//        if (!matcherEmail.matches()) {
//            return("Invalid email format.");
//        }


//    public ResponseEntity<?> signup(@Valid @RequestBody User users, BindingResult result){
//        if (result.hasErrors()){
//            return ResponseEntity.badRequest().body(result.getAllErrors());
//        }

//        UsersEntity savedUser=usersService.saveUser(users);
//        return ResponseEntity.ok(savedUser);
//        try{
//            User savedUser= userService.saveUser(users);
//            return ResponseEntity.ok(savedUser);
//        }
//        catch (IllegalArgumentException e){
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }






