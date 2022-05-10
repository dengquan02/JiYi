package com.ghz.diagnosis.service;

import com.ghz.diagnosis.entity.Record;
import java.util.List;


public interface RecordService {


    List<Record> patientQueryAllRecordsById(String patient_id);
    List<Record> doctorQueryAllRecordsById(String doctor_id);

    List<Record> queryAllRecords();


    int insert(Record record);


//    Record update(Record record);


    boolean deleteById(Integer recordId);

}
