package com.modulobytes.hrms_modulobytes.repository;

import com.modulobytes.hrms_modulobytes.entity.CompanyTaxDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxDetailsRepository extends JpaRepository<CompanyTaxDetails,Long> {
    //Optional<UserTaxDetails> findById(Long userId);
    boolean existsByPanNumber(String panNumber);

    boolean existsByTanNumber(String tanNumber);

    boolean existsByGstNumber(String gstNumber);

    boolean existsByCrcNumber(String crcNumber);

    boolean existsByMsmeRegistrationNumber(String msmeRegistrationNumber);

    boolean existsByProfessionalTaxRegistrationNumber(String professionalTaxRegistrationNumber);


}
