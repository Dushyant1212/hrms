package com.modulobytes.hrms_modulobytes.Validation;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUser {

    // Validate First Name
    public static String validateFirstName(String firstName) {
        if (!StringUtils.hasText(firstName)) {
            return "First name is required.";
        }
        return null; // Valid
    }
    // Validate Last Name
    public static String validateLastName(String lastName) {
        if (!StringUtils.hasText(lastName)) {
            return "Last name is required.";
        }
        return null; // Valid
    }

    //Validate Date Of Birth
    public static String validateDateOfBirth(String dateOfBirth) {
        if (!StringUtils.hasText(dateOfBirth)) {
            return "Date of birth is required.";
        }
        try {
            //chat-gpt ..
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
            LocalDate today = LocalDate.now();
            if (Period.between(dob, today).getYears() < 18) {
                return "You must be at least 18 years old.";
            }
        } catch (DateTimeParseException e) {
            return "Invalid date format. Please use MM/dd/yyyy.";
        }
        return null; // Valid
    }

    public static String validatePassword(String password) {
        if (password  == null || password.trim().isEmpty()) {
            return "Password is required.";
        }
        // Regex use in validate password
        // At least 8 characters long ->  1 uppercase letter, 1 lowercase letter, 1 digit, and 1 special character
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";
        Pattern patternPassword = Pattern.compile(passwordRegex);
        Matcher matcherPassword = patternPassword.matcher(password);


        if (!matcherPassword.matches()) {
            return "Password must be at least 8 characters long, contain one uppercase letter, one lowercase letter, one digit, and one special character.";
        }
//
//        if (!password.equals(confirmPassword)) {
//            return "Password and Confirm Password do not match.";
//        }

        return null; // Valid
    }



    // Validate Phone number using thr regex......
    public static String validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            return "Phone number is required."; // Check for null or empty phone number
        }

        String phoneRegex = "^\\\\+91\\\\d{10}$"; // phone number starts with +91 and is followed by 10 digits
        Pattern patternPhone = Pattern.compile(phoneRegex);
        Matcher matcherPhone = patternPhone.matcher(phoneNumber);
        if (!matcherPhone.matches()) {
            if (!phoneNumber.startsWith("+91")) {
                return "Phone number must start with +91.";
            } else if (phoneNumber.length() != 13) { // +91 + 10 digits = 13
                return "Phone number must have exactly 10 digits.";
            }
        }

        String digitsOnly = phoneNumber.substring(3);
        if (!digitsOnly.matches("\\d{10}")) {
            return "Phone number must contain exactly 10 numeric digits after +91.";
        }

        return null; // return null if valid
    }

    // Validate email using the regex...
    public static String validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return "Email is required."; // Check for null or empty email
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@gmail\\.com$"; // Only allow gmail emails
        Pattern patternEmail = Pattern.compile(emailRegex);
        Matcher matcherEmail = patternEmail.matcher(email);


        if (!matcherEmail.matches()) {
            return "Invalid email format."; // If not a valid format, return error message
        }
        return null; // return null if valid
    }

}
