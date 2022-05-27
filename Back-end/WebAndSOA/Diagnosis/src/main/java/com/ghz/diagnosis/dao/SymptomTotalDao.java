package com.ghz.diagnosis.dao;

import com.ghz.diagnosis.entity.DrugTotal;
import com.ghz.diagnosis.entity.SymptomTotal;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SymptomTotal)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-14 19:52:14
 */
public interface SymptomTotalDao {
    List<SymptomTotal>  query();

    int insert(SymptomTotal symptomTotal);

    int deleteById(String symptomName);

}
