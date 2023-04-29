package com.mopa.pacc.pmis.foreigntraining;

import java.util.List;
import java.util.Optional;

/*
 * Service layer interface to hold the business logic of teh application on top of repository
 */

public interface IForeignTrainingInfo {
        List<ForeignTrainingInfo> getAllForeignTrainings();
        Optional<ForeignTrainingInfo> findById(long id);
        ForeignTrainingInfo save (ForeignTrainingInfo foreignTraining);
        void delete (Long id);
        List<ForeignTrainingInfo> findByCuntryName(String cuntryName);
}
