package com.mopa.pacc.pmis.otherservice;

import java.util.List;
import java.util.Optional;

public interface IOtherService {
    List<OtherService> getAllOtherservices();
    Optional<OtherService> findById(long id);
    OtherService save(OtherService otherService);
    void delete (Long id);
    List<OtherService> findByEmployeeName(String employeeName);
    List<OtherService> findByDesignation(String designation);

}
