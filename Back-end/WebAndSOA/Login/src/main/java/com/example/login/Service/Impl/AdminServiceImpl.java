package com.example.login.Service.Impl;

import com.example.login.Dao.AdminDao;
import com.example.login.Dto.AdminDto;
import com.example.login.Entity.Admin;
import com.example.login.Service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    final AdminDao adminDao;

    @Autowired
    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public AdminDto login(AdminDto dto)
    {
        ModelMapper modelMapper = new ModelMapper ();
        Admin one = adminDao.findByName ( dto.getName () );
        if (one == null) {
            AdminDto ret = modelMapper.map ( null, AdminDto.class );
            ret.setIfExist ( false );
            return ret;
        }
        else {
            if (!one.getPassword ().equals (dto.getPassword ())) {
                AdminDto ret = modelMapper.map ( one, AdminDto.class );
                ret.setIfExist ( true );
                ret.setIfIllegal ( true );
                return ret;
            }
            // 如果ID密码都正确，返回
            else {
                AdminDto ret = modelMapper.map ( one, AdminDto.class );
                ret.setIfExist ( true );
                ret.setIfIllegal ( false );
                return ret;
            }
        }
    }


}
