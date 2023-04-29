package com.mopa.pacc.pmis.foreigntraining;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForeignTrainingInfoRepository extends JpaRepository<ForeignTrainingInfo, Long>{
    List<ForeignTrainingInfo>findByCuntryName(String cuntryName);
}
