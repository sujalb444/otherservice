package com.mopa.pacc.pmis.posting;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long> {
    List<Posting> findByDesignationContaining(String designation);
    List<Posting> findByOrganizationContaining(String organization);
}
