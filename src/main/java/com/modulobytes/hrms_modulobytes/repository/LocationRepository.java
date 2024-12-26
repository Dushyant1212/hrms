package com.modulobytes.hrms_modulobytes.repository;

import com.modulobytes.hrms_modulobytes.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location,Long> {
    // Find location by name and type
    // Find location by name and type




    List<Location> findByParentId(Long parentId); // Fetch locations by parent ID

    List<Location> findByType(String type);


    Optional<Location> findByNameAndType(String name, String type);
    //Optional<Location> findByNameAndType(String name, String type);
//    // Find all locations with a specific parent
//    List<Location> findByParentId(Long parentId);
//
//    // Find all countries (type and parent null)
//    List<Location> findByTypeAndParentIsNull(String type);
//
//    // Find states for a country or cities for a state
   // List<Location> findByTypeAndParentId(String type, Long parentId);

    //Optional<Location> findByNameAndType(String name, String type);

    List<Location> findByParentIdAndType(Long parentId, String type);

    @Query("SELECT l.name FROM Location l WHERE l.type = 'State' AND l.parentId = " +
            "(SELECT c.id FROM Location c WHERE c.type = 'Country' AND c.name = :countryName)")
    List<String> findStatesByCountry(@Param("countryName") String countryName);

}
