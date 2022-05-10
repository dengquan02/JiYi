package com.example.searchdoctor.service.Impl;

import com.example.searchdoctor.dao.NewDoctorDao;
import com.example.searchdoctor.dto.NewDoctorDto;
import com.example.searchdoctor.entity.NewDoctor;
import com.example.searchdoctor.service.NewDoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewDoctorServiceImpl implements NewDoctorService {
    final NewDoctorDao newDoctorDao;

    @Autowired
    public NewDoctorServiceImpl(NewDoctorDao newDoctorDao) {
        this.newDoctorDao = newDoctorDao;
    }

    @Override
    public List<NewDoctorDto> getDoctorNew(NewDoctorDto dto) {
        ModelMapper modelMapper=new ModelMapper();
        List<NewDoctor>one=newDoctorDao.findNewByHospital_id(dto.getHospital_id());

        List<NewDoctorDto>ret=new ArrayList<>();
        for(int i=0;i<one.size();i++)
        {
            ret.add(modelMapper.map(one.get(i),NewDoctorDto.class));
        }
        return ret;
    }

}
