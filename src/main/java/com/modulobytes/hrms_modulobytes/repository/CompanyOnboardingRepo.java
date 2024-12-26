package com.modulobytes.hrms_modulobytes.repository;

import com.modulobytes.hrms_modulobytes.entity.CompanyOnboardingDetail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyOnboardingRepo extends JpaRepository<CompanyOnboardingDetail,Long> {
    // Check if a company website already exists in the database
    //boolean existsByCompanyWebsite(String companyWebsite);
    //CompanyOnboardingDetail findByUserId(Long userId);

//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    @Query("SELECT c FROM CompanyOnboardingDetail c WHERE c.id = :userId")
//    CompanyOnboardingDetail findByIdForUpdate(@Param("userId") Long userId);


}
