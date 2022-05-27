package com.ghz.diagnosis.dao;

import com.ghz.diagnosis.entity.Record;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Record)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-14 15:55:12
 */
public interface RecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param recordId 主键
     * @return 实例对象
     */
    Record queryById(Integer recordId);
    List<Record> queryByPatientId(String patientId);
    List<Record> queryByDoctorId(String doctorId);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Record> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param record 实例对象
     * @return 对象列表
     */
    List<Record> queryAll(Record record);

    /**
     * 新增数据
     *
     * @param record 实例对象
     * @return 影响行数
     */
    int insert(Record record);

    /**
     * 修改数据
     *
     * @param record 实例对象
     * @return 影响行数
     */
    int update(Record record);

    /**
     * 通过主键删除数据
     *
     * @param recordId 主键
     * @return 影响行数
     */
    int deleteById(Integer recordId);

}
