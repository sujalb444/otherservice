package com.mopa.pacc.pmis.otherservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mopa.pacc.pmis.general.GeneralInfo;
import com.mopa.pacc.pmis.general.GeneralInfoService;
import com.mopa.pacc.pmis.posting.PostingDto;
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
//sujal project
@RestController
@RequestMapping("/api")
public class OtherServiceController {
    @Autowired
    OtherServiceService otherServiceService;
    @Autowired
    GeneralInfoService generalInfoService;
    @GetMapping("/otherservices")
    public ResponseEntity<List<OtherService>> getAllOtherServices(@RequestParam(required = false) String employeeName){
        try {
            List<OtherService> otherservices=new ArrayList<OtherService>();
            if(employeeName==null) {
                otherServiceService.getAllOtherservices().forEach(otherservices::add);
            }
             else{
                otherServiceService.findByEmployeeName(employeeName).forEach(otherservices::add);
            }
                if(otherservices.isEmpty()){
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            return new ResponseEntity<>(otherservices, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/otherservices")
    public ResponseEntity<OtherService> createOtherService(@RequestBody OtherServiceDto param){
        try {
            OtherService otherService =new OtherService();
            otherService.setFromDate(param.getFromDate());
            otherService.setEndDate(param.getEndDate());
            otherService.setEmployeeName(param.getEmployeeName());
            otherService.setEmployeeAddress(param.getEmployeeAddress());
            otherService.setServiceType(param.getServiceType());
            otherService.setDesignation(param.getDesignation());
            otherService.setRemarks(param.getRemarks());

            String govId = param.getGovId();

            // Check if Gov ID is exist
            GeneralInfo generalInfo = generalInfoService.findByGovId(govId)
                    .orElseThrow(() -> new Exception("Gov ID not found"));

            // We pulled genealInfo object from DB by govId (generalId, govId, firstName,
            // lastName)

            otherService.setGeneralInfo(generalInfo);

            OtherService _otherService = otherServiceService.save(otherService);

            return new ResponseEntity<>(_otherService, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/otherservices/{id}")
    public ResponseEntity<OtherService> getOtherServiceById(@PathVariable("id")Long id){
        Optional<OtherService> otherServicedata=otherServiceService.findById(id);
        if(otherServicedata.isPresent()){
            return new ResponseEntity<>(otherServicedata.get(), HttpStatus.OK);
        }
         {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/otherservices/{id}")
    public ResponseEntity<OtherService> updateOtherService(@PathVariable("id") Long id, @RequestBody OtherServiceDto param){
        try {
        Optional<OtherService> otherServiceData =otherServiceService.findById(id);
        if(otherServiceData.isPresent()){
            OtherService _otherservice=otherServiceData.get();
            _otherservice.setFromDate(param.getFromDate());
            _otherservice.setEndDate(param.getEndDate());
            _otherservice.setEmployeeName(param.getEmployeeName());
            _otherservice.setEmployeeAddress(param.getEmployeeAddress());
            _otherservice.setServiceType(param.getServiceType());
            _otherservice.setDesignation(param.getDesignation());
            _otherservice.setRemarks(param.getRemarks());
            // get gov ID
            // Check if Gov ID is exist
            GeneralInfo generalInfo = generalInfoService.findByGovId(param.getGovId())
                    .orElseThrow(() -> new Exception("Gov ID not found"));

            // We pulled genealInfo object from DB by govId (generalId, govId, firstName,
            // lastName)

            _otherservice.setGeneralInfo(generalInfo);

            return new ResponseEntity<>(otherServiceService.save(_otherservice), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


    @DeleteMapping("/otherservices/{id}")
    public ResponseEntity<HttpStatus> deleteOtherService(@PathVariable("id") long id)
    {
        try{
            otherServiceService.delete(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * Find list of posting data by designation
     *
     * @param param
     * @return
     */
    @PostMapping("/otherservices/designation")
    public ResponseEntity<List<OtherService>> getPostingByDesignation(@RequestBody OtherService param) {
        try {
            List<OtherService> otherServices = new ArrayList<OtherService>();
            otherServiceService.findByDesignation(param.getDesignation()).forEach(otherServices::add);
            if (otherServices.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(otherServices, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
