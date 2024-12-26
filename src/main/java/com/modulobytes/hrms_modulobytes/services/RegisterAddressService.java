package com.modulobytes.hrms_modulobytes.services;

import com.modulobytes.hrms_modulobytes.entity.RegisterAddress;
import com.modulobytes.hrms_modulobytes.repository.RegisterAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterAddressService {

    @Autowired
    private RegisterAddressRepository registerAddressRepository;

    public RegisterAddress saveRegisterAddress(RegisterAddress address) {
        return registerAddressRepository.save(address);
    }
}
