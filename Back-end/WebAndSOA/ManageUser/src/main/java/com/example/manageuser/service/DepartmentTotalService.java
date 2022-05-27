package com.example.manageuser.service;

import com.example.manageuser.entity.DepartmentTotal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (DepartmentTotal)表服务接口
 *
 * @author makejava
 * @since 2022-05-14 14:36:48
 */
public interface DepartmentTotalService {

    List<DepartmentTotal> queryAll();


    int insert(DepartmentTotal departmentTotal);


    int delete(String departmentName);

}
