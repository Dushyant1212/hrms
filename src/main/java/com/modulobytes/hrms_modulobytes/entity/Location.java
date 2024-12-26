package com.modulobytes.hrms_modulobytes.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "location22_new")
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(name = "change_date")
    private LocalDateTime changeDate = LocalDateTime.now();

    @Column(nullable = false)
    private String type; //enum... use ano..

    @Column(nullable = false)
    private String name;

    @Column() // Ensure the isocode cannot be null
    private String isocode;


    @Column(name = "parent_id")
    private Long parentId; // Points to the parent Location (Country → State → City)


//    @PreUpdate
//    public void preUpdate() {
//        this.changeDate = LocalDateTime.now();
//    }




}
