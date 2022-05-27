package com.ghz.diagnosis.service;

import com.ghz.diagnosis.entity.SymptomTotal;
import java.util.List;

/**
 * (SymptomTotal)表服务接口
 *
 * @author makejava
 * @since 2022-05-14 19:52:14
 */
public interface SymptomTotalService {
    List<SymptomTotal>  query();

    int insert(SymptomTotal symptomTotal);

    boolean deleteById(String symptomName);
}
