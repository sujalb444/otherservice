package com.mopa.pacc.pmis.spouseinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository 
public interface SpouseInfoRepository extends JpaRepository<SpouseInfo, Long>{
    List<SpouseInfo>findBySpouseName(String spouseName);
}
