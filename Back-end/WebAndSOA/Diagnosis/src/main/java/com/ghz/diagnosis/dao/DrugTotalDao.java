package com.ghz.diagnosis.dao;

import com.ghz.diagnosis.entity.DiseaseTotal;
import com.ghz.diagnosis.entity.DrugTotal;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (DrugTotal)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-14 19:51:51
 */
public interface DrugTotalDao {
    List<DrugTotal>  query();

    int insert(DrugTotal drugTotal);

    int deleteById(String drugName);

}
