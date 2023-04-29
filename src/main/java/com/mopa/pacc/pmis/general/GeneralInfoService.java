package com.mopa.pacc.pmis.general;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * Implementation of the Posting interface 
 */

 @Service 
public class GeneralInfoService implements IGeneralInfo{

    @Autowired 
    private GeneralInfoRepository generalInfoRepository; 
  
    @Override
    public List<GeneralInfo> getAll(){
        return generalInfoRepository.findAll(); 
    }
    @Override
    public Optional<GeneralInfo> findById(long id){
        return generalInfoRepository.findById(id);
    }
    @Override
    public GeneralInfo save(GeneralInfo generalInfo){
        return generalInfoRepository.save(generalInfo);
    }
    @Override
    public void delete (Long id){
        generalInfoRepository.deleteById(id);
    } 
    
    @Override
    public Optional<GeneralInfo> findByGovId(String govId){
       return  generalInfoRepository.findByGovId(govId); 
    }

    
}