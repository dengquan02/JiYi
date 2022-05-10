package com.example.searchhospital.service.Impl;

import com.example.searchhospital.dao.HospitalDao;
import com.example.searchhospital.dto.HospitalDto;
import com.example.searchhospital.entity.Hospital;
import com.example.searchhospital.service.HospitalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class HospitalServiceImpl implements HospitalService {
    final HospitalDao hospitalDao;

    @Autowired
    public HospitalServiceImpl(HospitalDao hospitalDao){
        this.hospitalDao=hospitalDao;
    }


    @Override
    public HospitalDto uploadHospital(HospitalDto dto) {
        ModelMapper modelMapper=new ModelMapper();
        // 根据dto映射实体类
        Hospital hospital=modelMapper.map(dto,Hospital.class);
        HospitalDto ret=modelMapper.map(hospitalDao.save(hospital),HospitalDto.class);

        return ret;
    }

    @Override
    public List<HospitalDto> getHospital(HospitalDto dto) {
        ModelMapper modelMapper=new ModelMapper();
        Hospital one=hospitalDao.findByHospital_id(dto.getHospital_id());

        List<HospitalDto>ret=new ArrayList<>();
        for(int i=0;i<1;i++)
        {
            ret.add(modelMapper.map(one,HospitalDto.class));
        }
        return ret;
    }

    @Override
    public List<HospitalDto> getAllHospital()
    {
        ModelMapper modelMapper = new ModelMapper ();
        List<Hospital> one = hospitalDao.findAll();
        List<HospitalDto> ret = new ArrayList<>();
        for (int i = 0; i < one.size(); i++) {
            ret.add ( modelMapper.map( one.get(i), HospitalDto.class ) );
        }
        return ret;
    }

    @Override
    public HospitalDto delete(HospitalDto dto)
    {
        hospitalDao.deleteByHospital_id(dto.getHospital_id());
        return dto;
    }


}
