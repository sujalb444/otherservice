package com.mopa.pacc.pmis.general;


import java.util.List;
import java.util.Optional;

/**
 * 
 * Service layer interface to hold the business logic of the application on top of repository
 */

public interface IGeneralInfo {
    List<GeneralInfo> getAll();
    Optional<GeneralInfo> findById(long id);
    GeneralInfo save(GeneralInfo generalInfo);
    void delete (Long id); 
    Optional<GeneralInfo> findByGovId(String govId);

 
}