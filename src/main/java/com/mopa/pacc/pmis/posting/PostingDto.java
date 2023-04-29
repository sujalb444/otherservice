package com.mopa.pacc.pmis.posting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** 
 * Data Transfer Object for Posting (form web or postman api)
 */
@Setter 
@Getter
@NoArgsConstructor
public class PostingDto {

    private Long id; 

    private String designation;

    private String organization;

    private String location;

    private String rank;

    // It will come from UI or Postman 
    String govId;

    // WE will find generalId by govId for saving
    Long generalId; 

    String fristName; 

    String lastName; 

}
