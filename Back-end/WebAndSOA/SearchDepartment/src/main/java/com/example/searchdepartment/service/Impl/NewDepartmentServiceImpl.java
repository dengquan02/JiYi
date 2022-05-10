package com.example.searchdepartment.service.Impl;

import com.example.searchdepartment.dao.NewDepartmentDao;
import com.example.searchdepartment.dto.NewDepartmentDto;
import com.example.searchdepartment.entity.NewDepartment;
import com.example.searchdepartment.service.NewDepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Gu HungJou
 * @date: 2022/1/6 14:58
 * Describe:
 */

@Service
public class NewDepartmentServiceImpl implements NewDepartmentService {

    final NewDepartmentDao newDepartmentDao;

    @Autowired
    public NewDepartmentServiceImpl(NewDepartmentDao newDepartmentDao){
        this.newDepartmentDao=newDepartmentDao;
    }

    @Override
    public List<NewDepartmentDto> getDepartmentOne(NewDepartmentDto dto) {
        ModelMapper modelMapper=new ModelMapper();
        List<NewDepartment> one =newDepartmentDao.findByHospital_id(dto.getHospital_id());

        List<NewDepartmentDto>ret=new ArrayList<>();
        for(int i=0;i<one.size();i++)
        {
            ret.add(modelMapper.map(one.get(i),NewDepartmentDto.class));
        }
        return ret;
    }
}
