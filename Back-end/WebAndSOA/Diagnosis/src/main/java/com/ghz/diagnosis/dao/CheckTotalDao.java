package com.ghz.diagnosis.dao;

import com.ghz.diagnosis.entity.CheckTotal;

import java.util.List;

/**
 * (CheckTotal)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-14 19:49:21
 */
public interface CheckTotalDao {

    List<CheckTotal> query();

    int insert(CheckTotal checkTotal);

    int deleteById(String checkName);

}
