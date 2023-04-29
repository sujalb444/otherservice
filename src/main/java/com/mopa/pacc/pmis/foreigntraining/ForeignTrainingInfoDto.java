package com.mopa.pacc.pmis.foreigntraining;

import java.time.Instant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Data Transfer Object for ForeignTraining (from web or postman api)
 */

 @Setter
 @Getter
 @NoArgsConstructor
 
public class ForeignTrainingInfoDto {

        private Long id;

          private String foreignTrainingTitleName;
          
          private String instituteName;
          
          private String cuntryName;
          
          private Instant fromDate;
          
          private Instant endDate;
          
          private String duration;
          
          private String cgpa;
          
          private String position;
          
          private String remarks;

          String govId;

          String firstName;

          String lastName;
    
}
