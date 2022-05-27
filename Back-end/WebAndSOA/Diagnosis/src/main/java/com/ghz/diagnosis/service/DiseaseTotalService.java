package com.ghz.diagnosis.service;

import com.ghz.diagnosis.entity.DiseaseTotal;
import java.util.List;

/**
 * (DiseaseTotal)表服务接口
 *
 * @author makejava
 * @since 2022-05-14 19:51:28
 */
public interface DiseaseTotalService {
    List<DiseaseTotal>  query();

    int insert(DiseaseTotal diseaseTotal);

    boolean deleteById(String diseaseName);
}
