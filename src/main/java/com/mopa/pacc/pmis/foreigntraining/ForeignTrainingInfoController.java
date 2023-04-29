package com.mopa.pacc.pmis.foreigntraining;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mopa.pacc.pmis.general.GeneralInfo;
import com.mopa.pacc.pmis.general.GeneralInfoService;


/*
 * Controller class to access service layer data
 */
@RestController
@RequestMapping("/api")

public class ForeignTrainingInfoController {

    @Autowired
    ForeignTrainingInfoService foreignTrainingInfoService;

    @Autowired
    GeneralInfoService generalInfoService;


@GetMapping("/foreigntrainings")
public ResponseEntity<List<ForeignTrainingInfo>> getAllForeignTrainings(@RequestParam(required = false) String cuntryName){
          try{
                    List<ForeignTrainingInfo> foreigntrainings = new ArrayList<ForeignTrainingInfo>();
                    if (cuntryName == null){
                        foreignTrainingInfoService.getAllForeignTrainings().forEach(foreigntrainings::add);
                              
                    }
                    else{
                        foreignTrainingInfoService.findByCuntryName(cuntryName).forEach(foreigntrainings::add);
                    }
                    if (foreigntrainings.isEmpty()){
                              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    }
                    return new ResponseEntity<>(foreigntrainings, HttpStatus.OK);
          }
          catch (Exception e){
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
}

@GetMapping("/foreigntrainings/{id}")   
public ResponseEntity<ForeignTrainingInfo> getforeigntrainingById(@PathVariable("id") Long id){
          Optional<ForeignTrainingInfo> foreigntrainingDate = foreignTrainingInfoService.findById(id);
          if(foreigntrainingDate.isPresent()){
                    return new ResponseEntity<>(foreigntrainingDate.get(), HttpStatus.OK);
          }
          else{
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
}    


@PostMapping("/foreigntrainings")
public ResponseEntity<ForeignTrainingInfo> CreateForeigntraining(@RequestBody ForeignTrainingInfoDto param){
          try{
                    ForeignTrainingInfo foreignTrainingToSave = new ForeignTrainingInfo();

                    foreignTrainingToSave.setForeignTrainingTitleName(param.getForeignTrainingTitleName());
                    foreignTrainingToSave.setInstituteName(param.getInstituteName());
                    foreignTrainingToSave.setCuntryName(param.getCuntryName());
                    foreignTrainingToSave.setFromDate(param.getFromDate());
                    foreignTrainingToSave.setEndDate(param.getEndDate());
                    foreignTrainingToSave.setDuration(param.getDuration());
                    foreignTrainingToSave.setCgpa(param.getCgpa());
                    foreignTrainingToSave.setPosition(param.getPosition());
                    foreignTrainingToSave.setRemarks(param.getRemarks());

                    String govId = param.getGovId();

                    //Check if GovId is exist

                    GeneralInfo generalInfo = generalInfoService.findByGovId(govId).orElseThrow(() -> new Exception("Gov ID not found"));
                    foreignTrainingToSave.setGeneralInfo(generalInfo);
                    ForeignTrainingInfo _ForeignTraining = foreignTrainingInfoService.save(foreignTrainingToSave);
                    return new ResponseEntity<>(_ForeignTraining, HttpStatus.CREATED);
          }
          catch (Exception e){
                    e.printStackTrace();
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
}

@PutMapping("/foreigntrainings/{id}")
public ResponseEntity<ForeignTrainingInfo> updateForeigntraining(@PathVariable("id") Long id, @RequestBody ForeignTrainingInfo param){
          try{
                    Optional<ForeignTrainingInfo> foreigntrainingData = foreignTrainingInfoService.findById(id);
                    if(foreigntrainingData.isPresent()){
                               ForeignTrainingInfo _ForeignTraining = foreigntrainingData.get();
                              _ForeignTraining.setForeignTrainingTitleName(param.getForeignTrainingTitleName());
                              _ForeignTraining.setInstituteName(param.getInstituteName());
                              _ForeignTraining.setCuntryName(param.getCuntryName());
                              _ForeignTraining.setFromDate(param.getFromDate());
                              _ForeignTraining.setEndDate(param.getEndDate());
                              _ForeignTraining.setDuration(param.getDuration());
                              _ForeignTraining.setCgpa(param.getCgpa());
                              _ForeignTraining.setPosition(param.getPosition());
                              _ForeignTraining.setRemarks(param.getRemarks());

                              return new ResponseEntity<>(foreignTrainingInfoService.save(_ForeignTraining), HttpStatus.OK);

                    }
                    else
                    {
                              return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                    }
                    
          }
          catch (Exception e){
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
          }
}

@DeleteMapping("/foreigntrainings/{id}")
public ResponseEntity<ForeignTrainingInfo> deleteForeigntraining(@PathVariable("id") long id){
          try{
                    foreignTrainingInfoService.delete(id);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
          catch (Exception e){
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
          }
}

}   

