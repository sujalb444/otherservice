package com.mopa.pacc.pmis.spouseinfo;

import java.util.List;
import java.util.Optional;

public interface ISpouseInfo {
    List<SpouseInfo> getAllSpouseInfo();
    Optional<SpouseInfo> findById(long id);
    SpouseInfo save(SpouseInfo spouseInfo);
    void delete(Long id);
    List<SpouseInfo> findBySpouseName(String spouseName);
}
