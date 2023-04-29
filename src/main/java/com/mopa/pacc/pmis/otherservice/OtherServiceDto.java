package com.mopa.pacc.pmis.otherservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
public class OtherServiceDto {
    private Long id;
    private Instant fromDate;
    private Instant  endDate;
    private String employeeName;
    private String employeeAddress;
    private String serviceType;
    private String designation;
    private String remarks;
	
	   // It will come from UI or Postman 
    String govId;

    // WE will find generalId by govId for saving
    Long generalId; 

    String fristName; 

    String lastName; 
}
