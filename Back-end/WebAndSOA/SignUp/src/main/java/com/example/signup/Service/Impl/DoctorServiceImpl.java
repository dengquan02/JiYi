package com.example.signup.Service.Impl;

import com.example.signup.Dao.DoctorDao;
import com.example.signup.Dto.DoctorDto;
import com.example.signup.Entity.Doctor;
import com.example.signup.Service.DoctorService;
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
    public DoctorDto register(DoctorDto dto)
    {
        ModelMapper modelMapper = new ModelMapper();
        // 根据手机号查询用户
        Doctor one = doctorDao.findDoctorByDoctor_id(dto.getDoctor_id());
        // 如果查询结果不为空，则已经注册
        if (one != null) {
            DoctorDto ret = modelMapper.map(one, DoctorDto.class);
            ret.setAlready(true);
            return ret;
        }
        // 如果结果为空，那么创建新的实体
        // 根据dto映射实体类
        Doctor user = modelMapper.map(dto, Doctor.class);
        DoctorDto ret = modelMapper.map(doctorDao.save(user), DoctorDto.class);
        ret.setIfExist(true);
        // 默认insert DML不会返回实体，需要进行一次select返回实体
        return ret;
    }
}
