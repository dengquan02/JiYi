package com.ghz.diagnosis.service.impl;

import com.ghz.diagnosis.entity.Record;
import com.ghz.diagnosis.dao.RecordDao;
import com.ghz.diagnosis.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Record)表服务实现类
 *
 * @author makejava
 * @since 2022-05-14 15:55:13
 */
@Service("recordService")
public class RecordServiceImpl implements RecordService {
    @Resource
    private RecordDao recordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param recordId 主键
     * @return 实例对象
     */
    @Override
    public Record queryById(Integer recordId) {
        return this.recordDao.queryById(recordId);
    }

    @Override
    public List<Record> queryByPatientId(String patientId) {
        return this.recordDao.queryByPatientId(patientId);
    }

    @Override
    public List<Record> queryByDoctorId(String doctorId) {
        return this.recordDao.queryByDoctorId(doctorId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Record> queryAllByLimit(int offset, int limit) {
        return this.recordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param record 实例对象
     * @return 实例对象
     */
    @Override
    public Record insert(Record record) {
        this.recordDao.insert(record);
        return record;
    }

    /**
     * 修改数据
     *
     * @param record 实例对象
     * @return 实例对象
     */
    @Override
    public Record update(Record record) {
        this.recordDao.update(record);
        return this.queryById(record.getRecordId());
    }

    /**
     * 通过主键删除数据
     *
     * @param recordId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer recordId) {
        return this.recordDao.deleteById(recordId) > 0;
    }
}
