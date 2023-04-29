package com.mopa.pacc.pmis.spouseinfo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class SpouseInfoService implements ISpouseInfo {
    @Autowired
    private SpouseInfoRepository spouseInfoRepository;

    @Override
    public List<SpouseInfo> getAllSpouseInfo(){
        return spouseInfoRepository.findAll();
    }
    @Override
    public Optional<SpouseInfo> findById(long id){
        return spouseInfoRepository.findById(id);
    }
    
    @Override
    public SpouseInfo save(SpouseInfo spouseInfo){
        return spouseInfoRepository.save(spouseInfo);
    }
    @Override
    public void delete(Long id){
        spouseInfoRepository.deleteById(id);
    }
    public List<SpouseInfo> findBySpouseName(String spouseName){
        return spouseInfoRepository.findBySpouseName(spouseName);
    }
}
