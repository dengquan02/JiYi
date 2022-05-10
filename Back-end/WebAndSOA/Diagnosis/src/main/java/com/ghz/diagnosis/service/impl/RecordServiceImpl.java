package com.ghz.diagnosis.service.impl;

import com.ghz.diagnosis.entity.Record;
import com.ghz.diagnosis.dao.RecordDao;
import com.ghz.diagnosis.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("recordService")
public class RecordServiceImpl implements RecordService {
    @Resource
    private RecordDao recordDao;


    @Override
    public List<Record> patientQueryAllRecordsById(String patient_id){
        return this.recordDao.patientQueryAllRecordsById(patient_id);
    }

    @Override
    public List<Record> doctorQueryAllRecordsById(String doctor_id){
        return this.recordDao.doctorQueryAllRecordsById(doctor_id);
    }

    @Override
    public List<Record> queryAllRecords() {
        return this.recordDao.queryAllRecords();
    }


    @Override
    public int insert(Record record) {
        int insert = this.recordDao.insert(record);
        return insert;
    }

//    @Override
//    public Record update(Record record) {
//        this.recordDao.update(record);
//        return this.queryById(record.getRecordId());
//    }


    @Override
    public boolean deleteById(Integer recordId) {
        return this.recordDao.deleteById(recordId) > 0;
    }
}
