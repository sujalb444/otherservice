package com.mopa.pacc.pmis.promotion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService implements IPromotion{
    
    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    public List<Promotion> getAllPromotions(){
        return promotionRepository.findAll();
    }

    @Override
    public Optional<Promotion> findById(Long id){
        return promotionRepository.findById(id);
    }
    @Override
    public Promotion save(Promotion promotion){
        return promotionRepository.save(promotion);
    }
    @Override
    public void delete (Long id){
        promotionRepository.deleteById(id);
    }
    @Override
    public List<Promotion> findByNatureOfPromotion(String natureOfPromotion){
        return promotionRepository.findByNatureOfPromotionContaining(natureOfPromotion);
    }


}
