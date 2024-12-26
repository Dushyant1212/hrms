package com.modulobytes.hrms_modulobytes.DTOs.Request;

import com.modulobytes.hrms_modulobytes.entity.Location;
import lombok.Data;

@Data
public class LocationRequestDTO {
    private Long id;
    private String type;
    private String name;
    private String isocode;
    private Long parentId;
}

