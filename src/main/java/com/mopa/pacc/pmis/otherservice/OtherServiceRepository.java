package com.mopa.pacc.pmis.otherservice;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OtherServiceRepository extends JpaRepository<OtherService, Long> {
 List<OtherService> findByEmployeeNameContaining(String employeeName);
 List<OtherService> findByDesignationContaining(String designation);

}

