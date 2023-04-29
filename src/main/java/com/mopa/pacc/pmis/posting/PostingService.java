package com.mopa.pacc.pmis.posting;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * Implementation of the Posting interface 
 */

 @Service 
public class PostingService implements IPosting{

    @Autowired 
    private PostingRepository postingRepository; 
  
    @Override
    public List<Posting> getAllPostings(){
        return postingRepository.findAll(); 
    }
    @Override
    public Optional<Posting> findById(long id){
        return postingRepository.findById(id);
    }
    @Override
    public Posting save(Posting posting){
        return postingRepository.save(posting);
    }
    @Override
    public void delete (Long id){
        postingRepository.deleteById(id);
    } 
    @Override
    public List<Posting> findByDesignation(String designation){
        return postingRepository.findByDesignationContaining(designation);
    }
    @Override
    public List<Posting> findByOrganization(String organization){
        return postingRepository.findByOrganizationContaining(organization);
    }

    
}
