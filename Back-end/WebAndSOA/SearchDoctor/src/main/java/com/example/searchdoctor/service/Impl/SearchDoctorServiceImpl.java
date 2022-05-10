package com.example.searchdoctor.service.Impl;


import com.example.searchdoctor.dao.DepartmentDao;
import com.example.searchdoctor.dao.HospitalDao;
import com.example.searchdoctor.dao.SearchDoctorDao;
import com.example.searchdoctor.dto.DoctorDto;
import com.example.searchdoctor.dto.SearchDoctorDto;
import com.example.searchdoctor.entity.Department;
import com.example.searchdoctor.entity.Hospital;
import com.example.searchdoctor.entity.SearchDoctor;
import com.example.searchdoctor.service.SearchDoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchDoctorServiceImpl implements SearchDoctorService {
    final SearchDoctorDao doctorDao;
    final HospitalDao mHospitalDao;
    final DepartmentDao mDepartmentDao;

    @Autowired
    public SearchDoctorServiceImpl(SearchDoctorDao doctorDao, HospitalDao hospitalDao, DepartmentDao departmentDao) {
        this.doctorDao = doctorDao;
        this.mDepartmentDao = departmentDao;
        this.mHospitalDao = hospitalDao;
    }

    @Override
    public SearchDoctorDto uploadDoctor(SearchDoctorDto dto) {
        ModelMapper modelMapper=new ModelMapper();
        // 根据dto映射实体类
        SearchDoctor doctor=modelMapper.map(dto, SearchDoctor.class);
        SearchDoctorDto ret=modelMapper.map(doctorDao.save(doctor), SearchDoctorDto.class);

        return ret;
    }

    @Override
    public List<SearchDoctorDto> getDoctor(SearchDoctorDto dto) {
        ModelMapper modelMapper=new ModelMapper();
        SearchDoctor one=doctorDao.findByDoctor_id(dto.getDoctor_id());

        List<SearchDoctorDto>ret=new ArrayList<>();
        for(int i=0;i<1;i++)
        {
            ret.add(modelMapper.map(one, SearchDoctorDto.class));
        }
        return ret;
    }

    @Override
    public List<SearchDoctorDto> getDoctorOne(SearchDoctorDto dto) {
        ModelMapper modelMapper=new ModelMapper();
        List<SearchDoctor>one=doctorDao.findByDepartment_id(dto.getDepartment_id());

        List<SearchDoctorDto>ret=new ArrayList<>();
        for(int i=0;i<one.size();i++)
        {
            ret.add(modelMapper.map(one.get(i),SearchDoctorDto.class));
        }
        return ret;
    }


    @Override
    public List<SearchDoctorDto> getFromHospital(SearchDoctorDto dto) {
        ModelMapper modelMapper=new ModelMapper();
        List<SearchDoctor>one=doctorDao.findByHospital_id(dto.getHospital_id());

        List<SearchDoctorDto>ret=new ArrayList<>();
        for(int i=0;i<one.size();i++)
        {
            ret.add(modelMapper.map(one.get(i),SearchDoctorDto.class));
        }
        return ret;
    }


    @Override
    public List<SearchDoctorDto> getAllDoctor()
    {
        ModelMapper modelMapper = new ModelMapper ();
        List<SearchDoctor> one = doctorDao.findAll();
        List<SearchDoctorDto> ret = new ArrayList<>();
        for (int i = 0; i < one.size(); i++) {
            ret.add ( modelMapper.map( one.get(i), SearchDoctorDto.class ) );
        }
        return ret;
    }

    @Override
    public DoctorDto getOne(String doctor_id )
    {
        SearchDoctor doctor = doctorDao.findByDoctor_id( doctor_id );
        DoctorDto dto = new DoctorDto();
        dto.setSex( doctor.getSex() );
        dto.setCtn( doctor.getReserve_ctn() );
        dto.setTitle( doctor.getTitle() );
        dto.setName( doctor.getName() );
        Department department = mDepartmentDao.findByDepartment_id( doctor.getDepartment_id() );
        dto.setDepartment( department.getName() );

        Hospital hospital = mHospitalDao.findByHospital_id( doctor.getHospital_id() );
        dto.setHospital( hospital.getName() );

        return dto;
    }

    @Override
    public List<DoctorDto> getAllDoctors()
    {
        List<SearchDoctor> one = doctorDao.findAll();
        List<DoctorDto> ret = new ArrayList<>();
        for (int i = 0; i < one.size(); i++) {
            DoctorDto tmp = new DoctorDto();
            tmp.setName( one.get(i).getName() );
            tmp.setTitle( one.get(i).getTitle() );
            tmp.setCtn( one.get(i).getReserve_ctn() );
            tmp.setSex( one.get(i).getSex() );
            tmp.setId( one.get(i).getDoctor_id() );
            if (one.get(i).getTitle().equals("主任医师")) {
                tmp.setPrice( 300 );
            }
            else if (one.get(i).getTitle().equals("副主任医师")) {
                tmp.setPrice( 200 );
            }
            else if (one.get(i).getTitle().equals("住院医生")) {
                tmp.setPrice( 80 );
            }
            else {
                tmp.setPrice( 50 );
            }
            Department department = mDepartmentDao.findByDepartment_id( one.get(i).getDepartment_id() );
            tmp.setDepartment( department.getName() );
            Hospital hospital = mHospitalDao.findByHospital_id( one.get(i).getHospital_id() );
            tmp.setHospital( hospital.getName() );
            ret.add( tmp );
        }
        return ret;
    }
}
