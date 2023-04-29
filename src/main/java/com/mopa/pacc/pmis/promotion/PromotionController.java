package com.mopa.pacc.pmis.promotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PromotionController {
    @Autowired
    PromotionService promotionService;

    @GetMapping("/promotions")
    public ResponseEntity<List<Promotion>> getAllPromotions(@RequestParam(required = false) String natureOfPromotion)
    {
        try{
            List<Promotion> promotions=new ArrayList<Promotion>();

            if(natureOfPromotion==null)

                //promotionService.findAll().forEach(promotions::add);
                promotionService.getAllPromotions().forEach(promotions::add);
            else
                promotionService.findByNatureOfPromotion(natureOfPromotion).forEach(promotions::add);

                
            if(promotions.isEmpty())
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }


            return new ResponseEntity<>(promotions,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/promotions/{id}")
    public ResponseEntity<Promotion> getPromotionById(@PathVariable("id") long id)
    {

        Optional<Promotion> promotionData=promotionService.findById(id);
        
        
        if(promotionData.isPresent())
        {
            return new ResponseEntity<>(promotionData.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/promotions")
    public ResponseEntity<Promotion> CreatePromotion(@RequestBody Promotion param)
    {
        try{
            Promotion promotionToSave=new Promotion();
            //promotionToSave.setProm_dt(param.getprom());
            promotionToSave.setPromotionDate(param.getPromotionDate());
            promotionToSave.setRankName(param.getRankName());
            promotionToSave.setPayScale(param.getPayScale());
            promotionToSave.setNatureOfPromotion(param.getNatureOfPromotion());
            promotionToSave.setActualPromotionDate(param.getActualPromotionDate());
            promotionToSave.setRemarks(param.getRemarks());

            Promotion _Promotion=promotionService.save(promotionToSave);

            return new ResponseEntity<>(_Promotion,HttpStatus.CREATED);
        }catch(Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/promotions/{id}")
    public ResponseEntity<Promotion> updatePromotion(@PathVariable("id") long id, @RequestBody Promotion promotion)
    {

        Optional<Promotion> promotionData=promotionService.findById(id);

        if(promotionData.isPresent())
        {
            Promotion _promotion=promotionData.get();

            _promotion.setPromotionDate(promotion.getPromotionDate());
            _promotion.setRankName(promotion.getRankName());
            _promotion.setPayScale(promotion.getPayScale());
            _promotion.setNatureOfPromotion(promotion.getNatureOfPromotion());
            _promotion.setActualPromotionDate(promotion.getActualPromotionDate());
            _promotion.setRemarks(promotion.getRemarks());


            return new ResponseEntity<>(promotionService.save(_promotion),HttpStatus.OK);

        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/promotions/{id}")
    public ResponseEntity<Promotion> deletePromotion(@PathVariable("id") long id)
    {
        try{

            promotionService.delete(id);

            promotionService.delete(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    
    @DeleteMapping("/promotions")
    public ResponseEntity<HttpStatus> deleteAllPromotions()
    {
        try{
            promotionService.delete();
            promotionRepository.deleteAll();


            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    */

    
}
