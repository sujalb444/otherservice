package com.mopa.pacc.pmis.posting;

import java.util.List;
import java.util.Optional;

/**
 * 
 * Service layer interface to hold the business logic of the application on top of repository
 */

public interface IPosting {
    List<Posting> getAllPostings();
    Optional<Posting> findById(long id);
    Posting save(Posting posting);
    void delete (Long id); 
    List<Posting> findByDesignation(String designation);
    List<Posting> findByOrganization(String organization);
}

