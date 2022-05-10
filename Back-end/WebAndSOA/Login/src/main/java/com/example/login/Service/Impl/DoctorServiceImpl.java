package com.example.login.Service.Impl;

import com.example.login.Dao.DoctorDao;
import com.example.login.Dto.DoctorDto;
import com.example.login.Entity.Doctor;
import com.example.login.Service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService
{
    final DoctorDao doctorDao;

    @Autowired
    public DoctorServiceImpl(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public DoctorDto login(DoctorDto dto)
    {
        ModelMapper modelMapper = new ModelMapper ();
        Doctor one = doctorDao.findDoctorByDoctor_id ( dto.getDoctor_id () );
        if (one == null) {
            DoctorDto ret = modelMapper.map ( null, DoctorDto.class );
            ret.setIfExist ( false );
            return ret;
        }
        else {
            if (!one.getPassword ().equals (dto.getPassword ())) {
                DoctorDto ret = modelMapper.map ( one, DoctorDto.class );
                ret.setIfExist ( true );
                ret.setIfIllegal ( true );
                return ret;
            }
            // 如果ID密码都正确，返回
            else {
                DoctorDto ret = modelMapper.map ( one, DoctorDto.class );
                ret.setIfExist ( true );
                ret.setIfIllegal ( false );
                return ret;
            }
        }
    }
}