package com.example.manageuser.Service.Impl;

import com.example.manageuser.Dao.PatientDao;
import com.example.manageuser.Dto.PatientDto;
import com.example.manageuser.Entity.Patient;
import com.example.manageuser.Service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class PatientServiceImpl implements PatientService
{
    final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public PatientDto delete(PatientDto dto)
    {
        Integer result = patientDao.deleteByPatient_id( dto.getPatient_id() );
        dto.setIsDeleted( result );
        return dto;
    }

    @Override
    public PatientDto edit(PatientDto dto)
    {
        Patient patient = patientDao.findPatientByPatient_id( dto.getPatient_id() );
        if ( dto.getPassword() == null ) {
            dto.setPassword ( patient.getPassword() );
        }
        if ( dto.getSex() == null ) {
            dto.setSex ( patient.getSex() );
        }
        if ( dto.getAge() == null ) {
            dto.setAge ( patient.getAge() );
        }
        if ( dto.getName() == null ) {
            dto.setName ( patient.getName() );
        }
        if ( dto.getEmail() == null ) {
            dto.setEmail ( patient.getEmail() );
        }

        ModelMapper modelMapper = new ModelMapper ();
        Patient report = modelMapper.map( dto, Patient.class );
        PatientDto ret = modelMapper.map ( patientDao.save ( report ), PatientDto.class );
        return ret;
    }

    @Override
    public PatientDto get(String patient_id)
    {
        ModelMapper modelMapper = new ModelMapper ();
        Patient report = patientDao.findPatientByPatient_id( patient_id );
        PatientDto ret = modelMapper.map ( report, PatientDto.class );
        return ret;
    }
}
