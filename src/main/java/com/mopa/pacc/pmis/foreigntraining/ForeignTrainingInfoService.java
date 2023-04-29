package com.mopa.pacc.pmis.foreigntraining;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Implementation of the ForeignTraining interface
 */

@Service
public class ForeignTrainingInfoService implements IForeignTrainingInfo{
        @Autowired
          private ForeignTrainingInfoRepository foreignTrainingRepository;

          @Override
          public List<ForeignTrainingInfo> getAllForeignTrainings(){
                  return foreignTrainingRepository.findAll();  
          }

          @Override
          public Optional<ForeignTrainingInfo> findById(long id){
                    return foreignTrainingRepository.findById(id);
          }

          @Override
          public ForeignTrainingInfo save(ForeignTrainingInfo foreignTraining){
                    return foreignTrainingRepository.save(foreignTraining);
          }

          @Override
          public void delete (Long id){
                    foreignTrainingRepository.deleteById(id);
          }

          @Override
          public List<ForeignTrainingInfo> findByCuntryName(String cuntryName){
                    return foreignTrainingRepository.findByCuntryName(cuntryName);
          }
}
