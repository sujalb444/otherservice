package com.mopa.pacc.pmis.otherservice;

import com.mopa.pacc.pmis.posting.IPosting;
import com.mopa.pacc.pmis.posting.Posting;
import com.mopa.pacc.pmis.posting.PostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OtherServiceService implements IOtherService {

    @Autowired
    private OtherServiceRepository otherServiceRepository;

    @Override
    public List<OtherService> getAllOtherservices(){
        return otherServiceRepository.findAll();
    }
    @Override
    public Optional<OtherService> findById(long id){
        return otherServiceRepository.findById(id);
    }
    @Override
    public OtherService save(OtherService otherService){
        return otherServiceRepository.save(otherService);
    }
    @Override
    public void delete (Long id){
        otherServiceRepository.deleteById(id);
    }
    @Override
    public List<OtherService> findByEmployeeName(String employeeName){
        return otherServiceRepository.findByEmployeeNameContaining(employeeName);
    }
    @Override
    public List<OtherService> findByDesignation(String designation){
        return otherServiceRepository.findByDesignationContaining(designation);
    }
}
