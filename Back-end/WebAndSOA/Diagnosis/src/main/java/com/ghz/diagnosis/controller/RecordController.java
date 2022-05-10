package com.ghz.diagnosis.controller;

import com.ghz.diagnosis.entity.*;
import com.ghz.diagnosis.service.RecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (Record)表控制层
 *
 * @author makejava
 * @since 2021-11-24 20:58:40
 */
@Api(tags="诊疗记录服务")
@RestController
@RequestMapping("/api/v1/record")
public class RecordController {
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 服务对象
     */
    @Resource
    private RecordService recordService;

    @ApiOperation("查询病人记录")
    @GetMapping("/patientQueryAllRecords/{patientId}")
    public List<ReturnData> patientQueryAllRecords(@PathVariable("patientId") String patientId) {
        List<ReturnData> list=new ArrayList<>();
        List<Record> records = recordService.patientQueryAllRecordsById(patientId);
        for(Record record:records){
            ReturnData returnData=new ReturnData();
            returnData.setRecordId(record.getRecordId());
            returnData.setDate(record.getDate());
            returnData.setContent(record.getContent());
            returnData.setPatientId(record.getPatientId());
            returnData.setDoctorId(record.getDoctorId());
            ResponseEntity<Doctor[]> re = restTemplate.exchange("http://127.0.0.1:8006/api/v1/doctor/get?doctor_id="+record.getDoctorId(), HttpMethod.GET,null, Doctor[].class);
            Doctor[] doctors = re.getBody();
            assert doctors != null;
            returnData.setDoctorName(doctors[0].getName());
            System.out.println(doctors[0]);
            ResponseEntity<Department[]> res = restTemplate.exchange("http://127.0.0.1:8003/api/v1/department/get?department_id="+doctors[0].getDepartment_id(), HttpMethod.GET, null, Department[].class);
            Department[] departments = res.getBody();
            assert departments != null;
            returnData.setDepartName(departments[0].getName());
            ResponseEntity<Hospital[]> resp = restTemplate.exchange("http://127.0.0.1:8007/api/v1/hospital/get?hospital_id="+doctors[0].getHospital_id(), HttpMethod.GET, null, Hospital[].class);
            Hospital[] hospitals = resp.getBody();

            assert hospitals != null;
            returnData.setHospitalName(hospitals[0].getName());
            list.add(returnData);
        }
        System.out.println(list);
return list;
    }

    @ApiOperation("查询医生记录")
    @GetMapping("/doctorQueryAllRecords/{doctorId}")
    public List<Record> doctorQueryAllRecords(@PathVariable("doctorId") String doctorId) {
        return recordService.doctorQueryAllRecordsById(doctorId);
    }

    @ApiOperation("更新记录")
    @GetMapping("/updateRecords/{patientId}/{doctorId}/{content}")
    public int updateRecords(@PathVariable("doctorId") String doctorId,
                                      @PathVariable("patientId") String patientId,
                                      @PathVariable("content") String content) {
      Record record=new Record();
      record.setContent(content);
      record.setDoctorId(doctorId);
      record.setPatientId(patientId);
      Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = simpleDateFormat.format(date);
        System.out.println(d);
        record.setDate(d);
        int i = recordService.insert(record);
        return i;
    }
}
