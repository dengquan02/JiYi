package com.example.manageuser.dao;

import com.example.manageuser.entity.DepartmentTotal;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (DepartmentTotal)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-14 14:36:48
 */
public interface DepartmentTotalDao {

    List<DepartmentTotal> queryAll();


    int insert(DepartmentTotal departmentTotal);


    int delete(@Param("departmentName") String departmentName);

}
