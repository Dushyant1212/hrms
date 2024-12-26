package com.modulobytes.hrms_modulobytes.repository;


import com.modulobytes.hrms_modulobytes.entity.RegisterAddress;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RegisterAddressRepository extends JpaRepository<RegisterAddress,Long> {
   // RegisterAddress findByUserId(Long userId);
   // RegisterAddress findAllByUserId(Long id);
    //Optional<RegisterAddress> findById(Long id);
}
