package com.example.login.Service.Impl;

import com.example.login.Dao.PatientDao;
import com.example.login.Dto.DoctorDto;
import com.example.login.Dto.PatientDto;
import com.example.login.Entity.Doctor;
import com.example.login.Entity.Patient;
import com.example.login.Service.PatientService;
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
    public PatientDto login(PatientDto dto)
    {
        ModelMapper modelMapper = new ModelMapper ();
        Patient one = patientDao.findPatientByPatient_id ( dto.getPatient_id () );
        if (one == null) {
            PatientDto ret = modelMapper.map ( null, PatientDto.class );
            ret.setIfExist ( false );
            return ret;
        }
        else {
            if (!one.getPassword ().equals (dto.getPassword ())) {
                PatientDto ret = modelMapper.map ( one, PatientDto.class );
                ret.setIfExist ( true );
                ret.setIfIllegal ( true );
                return ret;
            }
            // 如果ID密码都正确，返回
            else {
                PatientDto ret = modelMapper.map ( one, PatientDto.class );
                ret.setIfExist ( true );
                ret.setIfIllegal ( false );
                return ret;
            }
        }
    }
}
