package com.ghz.diagnosis.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.ghz.diagnosis.entity.Record;
import com.ghz.diagnosis.service.RecordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * (Record)表控制层
 *
 * @author makejava
 * @since 2022-05-14 15:47:04
 */
@RestController
@RequestMapping("/diagnosis")
public class RecordController {
    public static final String endpoint = "oss-cn-shanghai.aliyuncs.com";
    public static final String accessKeyId = "LTAI5t9WQu7vNQFDQ6W7Xcu2";
    public static final String accessKeySecret = "KRg1GEEFpIGNPuBxzsKmEYn9HGt8WA";
    public static final String bucketName = "ghzoss";
    /**
     * 服务对象
     */
    @Resource
    private RecordService recordService;
    @Resource
    private patientInfo patientInfo;
    @Resource
    private doctorInfo doctorInfo;

    @ApiOperation(value = "查询诊疗记录", notes = "")
    @GetMapping("/queryById/{id}")
    public Object queryById(@PathVariable Integer id, HttpServletResponse response) {
        Record record = this.recordService.queryById(id);
        Map<String, Object> map = new HashMap<>();
        Object patientInfo = this.patientInfo.getPatientInfo(record.getPatientId(), response);
        Object doctorInfo = this.doctorInfo.getDoctorInfo(record.getDoctorId(), response);
        map.put("patientInfo", patientInfo);
        map.put("doctorInfo", doctorInfo);
        map.put("detailRecord", record);
        String url = null;
        if (record.getAttachment() == 1) {
            url = "https://ghzoss.oss-cn-shanghai.aliyuncs.com/" + id + ".pdf";
        }
        map.put("attachment", url);
        return record;
    }

//    public static OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

    @ApiOperation(value = "增加诊疗记录", notes = "symptom=>complaint,disease=>disable;attachment PDF only;return recordId")
    @PostMapping("/addRecord")
    public Object addRecord(@RequestParam String patientId,
                            @RequestParam String doctorId,
                            String complaint,
                            String check,
                            String drug,
                            String content,
                            String disable,
                            MultipartFile attachment,
                            HttpServletResponse response) throws Exception {
        Record record = new Record();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = formatter.format(date);
        record.setPatientId(patientId);
        record.setDoctorId(doctorId);
        record.setComplaint(complaint);
        record.setCheck(check);
        record.setDrug(drug);
        record.setContent(content);
        record.setDisable(disable);
        record.setRecordDate(time);
        Record r = recordService.insert(record);
        if (attachment != null) {
            String endpoint = RecordController.endpoint;
            String accessKeyId = RecordController.accessKeyId;
            String accessKeySecret = RecordController.accessKeySecret;
            String bucketName = RecordController.bucketName;
            String url = null;

            //创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            //获取上传文件输入流
            InputStream inputStream = attachment.getInputStream();
            //获取文件名称
//            String fileName = attachment.getOriginalFilename();
//
//            //保证文件名唯一，去掉uuid中的'-'
//            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//            fileName = uuid + fileName;
//
//            //把文件按日期分类，构建日期路径：avatar/2019/02/26/文件名
//            //String datePath = new Date().toString("yyyy/MM/dd");
//            String datePath = "2021";
            //拼接
            String fileName = String.valueOf(r.getRecordId());

            //调用oss方法上传到阿里云
            //第一个参数：Bucket名称
            //第二个参数：上传到oss文件路径和文件名称
            //第三个参数：上传文件输入流
            ossClient.putObject(bucketName, fileName, inputStream);

            //把上传后把文件url返回
            //https://xppll.oss-cn-beijing.aliyuncs.com/01.jpg
            url = "https://" + bucketName + "." + endpoint + "/" + fileName;
            //关闭OSSClient
            ossClient.shutdown();
            r.setAttachment(1);
        } else r.setAttachment(0);
        Record update = recordService.update(r);
        return update.getRecordId();
    }


    @ApiOperation(value = "删除诊疗记录", notes = "attachment PDF only;return recordId")
    @GetMapping("/deleteRecord/{recordId}")
    public Object deleteRecord(@PathVariable Integer recordId) {
        boolean b = recordService.deleteById(recordId);
        if (b) return 1;
        else return -1;
    }

    @ApiOperation(value = "按患者查询诊疗记录", notes = "")
    @GetMapping("/queryByPatientId/{PatientId}")
    public Object queryByPatientId(@PathVariable String PatientId, HttpServletResponse response) {
        List<Record> records = this.recordService.queryByPatientId(PatientId);
        List<Map<String, Object>> list = new ArrayList<>();
        for (Record record : records) {
            Map<String, Object> map = new HashMap<>();
//        Object patientInfo = this.patientInfo.getPatientInfo(record.getPatientId(), response);
            Object doctorInfo = this.doctorInfo.getDoctorInfo(record.getDoctorId(), response);
//            map.put("patientInfo", patientInfo);
            map.put("doctorInfo", doctorInfo);
            map.put("detailRecord", record);
            String url = null;
            if (record.getAttachment() == 1) {
                url = "https://ghzoss.oss-cn-shanghai.aliyuncs.com/" + record.getRecordId() + ".pdf";
            }
            map.put("attachment", url);
            list.add(map);
        }
        return list;
    }

    @ApiOperation(value = "按医生查询诊疗记录", notes = "")
    @GetMapping("/queryByDoctorId/{doctorId}")
    public Object queryByDoctorId(@PathVariable String doctorId, HttpServletResponse response) {
        List<Record> records = this.recordService.queryByDoctorId(doctorId);
        List<Map<String, Object>> list = new ArrayList<>();
        for (Record record : records) {
            Map<String, Object> map = new HashMap<>();
            Object patientInfo = this.patientInfo.getPatientInfo(record.getPatientId(), response);
//            Object doctorInfo = this.doctorInfo.getDoctorInfo(record.getDoctorId(), response);
            map.put("patientInfo", patientInfo);
//            map.put("doctorInfo", doctorInfo);
            map.put("detailRecord", record);
            String url = null;
            if (record.getAttachment() == 1) {
                url = "https://ghzoss.oss-cn-shanghai.aliyuncs.com/" + record.getRecordId() + ".pdf";
            }
            map.put("attachment", url);
            list.add(map);
        }
        return list;
    }


    @ApiOperation(value = "打分", notes = "")
    @PostMapping("/judge")
    public Object queryByDoctorId(String judge,
                                  @RequestParam Integer id,
                                  @RequestParam Integer star,
                                  HttpServletResponse response) {
        if(judge==null||judge.equals("")){
            judge="默认好评";
        }
        Record record = recordService.queryById(id);
        record.setJudge(judge);
        record.setStar(star);
        return recordService.update(record);
    }
}
