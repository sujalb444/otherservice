package com.mopa.pacc.pmis.promotion;


import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    List<Promotion> findByNatureOfPromotionContaining(String natureOfPromotion);

    List<Promotion> findByNatureOfPromotion(String natureOfPromotion);

    //Optional<GeneralInfo> findByGovId(String govId);

}
