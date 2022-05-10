package com.example.manageuser.Service.Impl;

import com.example.manageuser.Dao.DoctorDao;
import com.example.manageuser.Dto.DoctorDto;
import com.example.manageuser.Entity.Doctor;
import com.example.manageuser.Service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class DoctorServiceImpl implements DoctorService
{
    final DoctorDao doctorDao;

    @Autowired
    public DoctorServiceImpl(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public DoctorDto delete(DoctorDto dto)
    {
        Integer result = doctorDao.deleteByDoctor_id( dto.getDoctor_id() );
        dto.setIsDeleted( result );
        return dto;
    }

    @Override
    public DoctorDto deletebyone(DoctorDto dto)
    {
        Integer result = doctorDao.deleteByHospital_id( dto.getHospital_id() );
        dto.setIsDeleted( result );
        return dto;
    }

    @Override
    public DoctorDto edit(DoctorDto dto)
    {
        Doctor doctor = doctorDao.findDoctorByDoctor_id( dto.getDoctor_id() );
        dto.setDepartment_id( doctor.getDepartment_id() );
        dto.setEmail( doctor.getEmail() );
        dto.setHospital_id( doctor.getHospital_id() );
        if ( dto.getPassword() == null ) {
            dto.setPassword ( doctor.getPassword() );
        }
        if ( dto.getSex() == null ) {
            dto.setSex ( doctor.getSex() );
        }
        if ( dto.getTitle() == null ) {
            dto.setTitle ( doctor.getTitle() );
        }
        if ( dto.getName() == null ) {
            dto.setName ( doctor.getName() );
        }

        ModelMapper modelMapper = new ModelMapper ();
        Doctor report = modelMapper.map( dto, Doctor.class );
        DoctorDto ret = modelMapper.map ( doctorDao.save ( report ), DoctorDto.class );
        return ret;
    }
}
