package com.ghz.diagnosis.dao;

import com.ghz.diagnosis.entity.CheckTotal;
import com.ghz.diagnosis.entity.DiseaseTotal;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (DiseaseTotal)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-14 19:51:28
 */
public interface DiseaseTotalDao {
    List<DiseaseTotal>  query();

    int insert(DiseaseTotal diseaseTotal);

    int deleteById(String diseaseName);

}
