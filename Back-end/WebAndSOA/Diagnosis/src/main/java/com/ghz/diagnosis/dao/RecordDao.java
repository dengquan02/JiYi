package com.ghz.diagnosis.dao;

import com.ghz.diagnosis.entity.Record;
import org.apache.ibatis.annotations.Param;
import java.util.List;


public interface RecordDao {


    List<Record> patientQueryAllRecordsById(String patient_id);
    List<Record> doctorQueryAllRecordsById(String doctor_id);


    List<Record> queryAllRecords();



    List<Record> queryAll(Record record);


    int insert(Record record);


//    int update(Record record);


    int deleteById(Integer recordId);

}
