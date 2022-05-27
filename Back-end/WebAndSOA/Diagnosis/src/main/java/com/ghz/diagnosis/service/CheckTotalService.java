package com.ghz.diagnosis.service;

import com.ghz.diagnosis.entity.CheckTotal;
import java.util.List;

/**
 * (CheckTotal)表服务接口
 *
 * @author makejava
 * @since 2022-05-14 19:49:21
 */
public interface CheckTotalService {
    List<CheckTotal> query();

    int insert(CheckTotal checkTotal);

    boolean deleteById(String checkName);

}
