package com.mopa.pacc.pmis.promotion;

import java.util.List;
import java.util.Optional;

public interface IPromotion {
    List<Promotion> getAllPromotions();
    Optional<Promotion> findById(Long id);
    Promotion save(Promotion promotion);
    void delete (Long id);
    List<Promotion> findByNatureOfPromotion(String natureOfPromotion);
}
