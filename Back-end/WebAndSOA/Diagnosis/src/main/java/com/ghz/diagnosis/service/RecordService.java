package com.ghz.diagnosis.service;

import com.ghz.diagnosis.entity.Record;
import java.util.List;

/**
 * (Record)表服务接口
 *
 * @author makejava
 * @since 2022-05-14 15:55:13
 */
public interface RecordService {

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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Record> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param record 实例对象
     * @return 实例对象
     */
    Record insert(Record record);

    /**
     * 修改数据
     *
     * @param record 实例对象
     * @return 实例对象
     */
    Record update(Record record);

    /**
     * 通过主键删除数据
     *
     * @param recordId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer recordId);

}
