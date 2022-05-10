package com.example.searchdepartment.service.Impl;


import com.example.searchdepartment.dao.DepartmentDao;
import com.example.searchdepartment.dto.DepartmentDto;
import com.example.searchdepartment.entity.Department;
import com.example.searchdepartment.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    final DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao){
        this.departmentDao=departmentDao;
    }


    @Override
    public DepartmentDto uploadDepartment(DepartmentDto dto) {

        ModelMapper modelMapper=new ModelMapper();
        // 根据dto映射实体类
        Department department=modelMapper.map(dto, Department.class);
        DepartmentDto ret=modelMapper.map(departmentDao.save(department),DepartmentDto.class);

        return ret;
    }

    @Override
    public List<DepartmentDto> getDepartment(DepartmentDto dto) {
        ModelMapper modelMapper=new ModelMapper();
        Department one=departmentDao.findByDepartment_id(dto.getDepartment_id());

        List<DepartmentDto>ret=new ArrayList<>();
        for(int i=0;i<1;i++)
        {
            ret.add(modelMapper.map(one,DepartmentDto.class));
        }
        return ret;
    }

    @Override
    public List<DepartmentDto> getDepartmentOne(DepartmentDto dto) {
        ModelMapper modelMapper=new ModelMapper();
        List<Department>one=departmentDao.findByHospital_id(dto.getHospital_id());

        List<DepartmentDto>ret=new ArrayList<>();
        for(int i=0;i<one.size();i++)
        {
            ret.add(modelMapper.map(one.get(i),DepartmentDto.class));
        }
        return ret;
    }

    @Override
    public DepartmentDto deletebyone(DepartmentDto dto)
    {
        departmentDao.deleteByHospital_id( dto.getHospital_id() );
        return dto;
    }

}
