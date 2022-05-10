package com.example.signup.Service.Impl;

import com.example.signup.Dao.DoctorDao;
import com.example.signup.Dao.PatientDao;
import com.example.signup.Dto.DoctorDto;
import com.example.signup.Dto.PatientDto;
import com.example.signup.Entity.Doctor;
import com.example.signup.Entity.Patient;
import com.example.signup.Service.DoctorService;
import com.example.signup.Service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService
{
    final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public PatientDto register(PatientDto dto)
    {
        ModelMapper modelMapper = new ModelMapper();
        // 根据手机号查询用户
        Patient one = patientDao.findPatientByPatient_id(dto.getPatient_id());
        // 如果查询结果不为空，则已经注册
        if (one != null) {
            PatientDto ret = modelMapper.map(one, PatientDto.class);
            ret.setAlready(true);
            return ret;
        }
        // 如果结果为空，那么创建新的实体
        // 根据dto映射实体类
        Patient user = modelMapper.map(dto, Patient.class);
        PatientDto ret = modelMapper.map(patientDao.save(user), PatientDto.class);
        ret.setIfExist(true);
        // 默认insert DML不会返回实体，需要进行一次select返回实体
        return ret;
    }
}