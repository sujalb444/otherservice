package com.mopa.pacc.pmis.general;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralInfoRepository extends JpaRepository<GeneralInfo, Long> {

    Optional<GeneralInfo> findByGovId(String govId);


   
}

