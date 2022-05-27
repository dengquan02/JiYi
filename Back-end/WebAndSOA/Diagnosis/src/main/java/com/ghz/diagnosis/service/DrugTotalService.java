package com.ghz.diagnosis.service;

import com.ghz.diagnosis.entity.DrugTotal;
import java.util.List;

/**
 * (DrugTotal)表服务接口
 *
 * @author makejava
 * @since 2022-05-14 19:51:51
 */
public interface DrugTotalService {

    List<DrugTotal>  query();

    int insert(DrugTotal drugTotal);

    boolean deleteById(String drugName);

}
