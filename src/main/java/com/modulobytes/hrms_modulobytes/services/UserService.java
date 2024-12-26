package com.modulobytes.hrms_modulobytes.services;
import com.modulobytes.hrms_modulobytes.DTOs.Request.UserSignupRequestDTO;
import com.modulobytes.hrms_modulobytes.entity.User;
import com.modulobytes.hrms_modulobytes.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private ModelMapper modelMapper;
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

//    public boolean existsById(Long userId) {
//        System.out.println("Checking if user exists with ID: " + userId);  // Add logging
//        return userRepo.existsById(userId);
//
//    }




    public void registerNewUser(UserSignupRequestDTO userSignupRequestDTO) {
        // Check if email exists..
        if (userRepo.existsByEmail(userSignupRequestDTO.getEmail())) {
            throw new IllegalArgumentException("Email is already in use.");
        }
        // Check if PhoneNumber exists..
        if (userRepo.existsByPhoneNumber(userSignupRequestDTO.getPhoneNumber())) {
            throw new IllegalArgumentException("Phone number is already in use.");
        }
        if(!userSignupRequestDTO.getPassword().equals(userSignupRequestDTO.getConfirmPassword())){
            throw new IllegalArgumentException("Password and Confirm Password do not match.");
        }


        User user=modelMapper.map(userSignupRequestDTO, User.class);
        userRepo.save(user); //save the user
    }


    public boolean validateUser(String email, String password) {
        List<User> users = userRepo.findByEmail(email);
        // Check if no user is found
        if (users.isEmpty()) {
            return false;
        }

        if (users.size() > 1) {
            return false;
        }
        User user = users.get(0);  // Get the single user from the list
        return user.getPassword().equals(password);
    }
}


//  ..... Use the Model Mapper...
//        User user = new User();
//        user.setFirstName(signupRequestDTO.getFirstName());
//        user.setMiddleName(signupRequestDTO.getMiddleName());
//        user.setLastName(signupRequestDTO.getLastName());
//        user.setEmail(signupRequestDTO.getEmail());
//        user.setPhoneNumber(signupRequestDTO.getPhoneNumber());
//        user.setDateOfBirth(String.valueOf(signupRequestDTO.getDateOfBirth()));
//        user.setPassword(signupRequestDTO.getPassword());
//        user.setConfirmPassword(signupRequestDTO.getConfirmPassword());

        // Validate if password and confirm password match
//        if (!signupRequestDTO.getPassword().equals(signupRequestDTO.getConfirmPassword())) {
//            throw new IllegalArgumentException("Password and Confirm Password do not match.");
//        }




//    public User saveUser(@Valid User users){ //change name..
//
//        // Check if email already exists in database....
//        if (userRepo.existsByEmail(users.getEmail())) {
//            throw new IllegalArgumentException("Email is already in use");
//        }
//
//        // Check if phone number already exists in database...
//        if (userRepo.existsByPhoneNumber(users.getPhoneNumber())) {
//            throw new IllegalArgumentException("Phone number is already in use");
//        }
//

//        return userRepo.save(users);
//    }



//        String phoneRegex = "^\\\\+91[0-9]{10}$";
//        Pattern patternPhone =Pattern.compile(phoneRegex);
//        Matcher matcherPhone =patternPhone.matcher(signupRequestDTO.getPhoneNumber());
//
//        if(!matcherPhone.matches()){
//            // Check if the issue is due to length
//            if (!signupRequestDTO.getPhoneNumber().startsWith("+91")) {
//                throw new IllegalArgumentException("Phone number must start with +91.");
//            } else if (signupRequestDTO.getPhoneNumber().length() != 13) { // 3 chars for +91 + 10 digits = 13
//                throw new IllegalArgumentException("Phone number must have exactly 10 digits.");
//            }
//        }
//
//
//        // emailRegex = ^[a-zA-Z0-9_+&*-]+(?:\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\.)+[a-zA-Z]{2,7}$  -----  "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(gmail\\.com|email\\.com)$
//        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@gmail\\.com$";
//
//
//        // Validate email format using regex..
//        Pattern patternEmail = Pattern.compile(emailRegex);
//        Matcher matcherEmail = patternEmail.matcher(signupRequestDTO.getEmail());
//
//        if (!matcherEmail.matches()) {
//            throw new IllegalArgumentException("Invalid email format.");
//        }
//


