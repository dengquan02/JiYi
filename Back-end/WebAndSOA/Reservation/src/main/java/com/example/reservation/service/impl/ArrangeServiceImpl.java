package com.example.reservation.service.impl;


import com.example.reservation.dao.ArrangeDao;
import com.example.reservation.dao.DepartmentDao;
import com.example.reservation.dao.HospitalDao;
import com.example.reservation.dao.SearchDoctorDao;
import com.example.reservation.dto.ArrangeDto;
import com.example.reservation.dto.DoctorDto;
import com.example.reservation.dto.ReserveGetDto;
import com.example.reservation.entity.*;
import com.example.reservation.service.ArrangeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class ArrangeServiceImpl implements ArrangeService
{
    final ArrangeDao mArrangeDao;
    final SearchDoctorDao mSearchDoctorDao;
    final DepartmentDao mDepartmentDao;
    final HospitalDao mHospitalDao;

    @Autowired
    public ArrangeServiceImpl(ArrangeDao arrangeDao, SearchDoctorDao searchDoctorDao, DepartmentDao departmentDao, HospitalDao hospitalDao) {
        this.mArrangeDao = arrangeDao;
        this.mSearchDoctorDao = searchDoctorDao;
        this.mDepartmentDao = departmentDao;
        this.mHospitalDao = hospitalDao;
    }

    @Override
    public List<ArrangeDto> getReservation(String doctorId) {
        List<Arrange> all = mArrangeDao.findAllByDoctor( doctorId );
        List<ArrangeDto> ret = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for( int i = 0; i < all.size(); i++ ) {
            ArrangeDto tmp = modelMapper.map( all.get(i), ArrangeDto.class );
            ret.add( tmp );
        }
        return ret;
    }


    @Override
    public List<DoctorDto> getAllDoctorByDay(String day, Integer hospital_id, Integer department_id)
    {
        List<DoctorDto> ret = new ArrayList<>();
        List<Arrange> one = mArrangeDao.findAllByDayAndHospital_idAndDepartment_id(day, hospital_id, department_id);
        List<String> doctors = new ArrayList<>();
        for(int i = 0; i < one.size(); i++)
        {
            doctors.add( one.get(i).getDoctor_id() );
        }
        // 对doctors去重
        HashSet h = new HashSet(doctors);
        doctors.clear();
        doctors.addAll(h);

        for (int i = 0; i < doctors.size(); i++) {
            SearchDoctor doctor = mSearchDoctorDao.findByDoctor_id( doctors.get(i) );
            DoctorDto tmp = new DoctorDto();
            tmp.setName( doctor.getName() );
            tmp.setTitle( doctor.getTitle() );
            tmp.setCtn( doctor.getReserve_ctn() );
            tmp.setSex( doctor.getSex() );
            tmp.setId( doctor.getDoctor_id() );
            Department department = mDepartmentDao.findByDepartment_id( doctor.getDepartment_id() );
            tmp.setDepartment( department.getName() );
            Hospital hospital = mHospitalDao.findByHospital_id( doctor.getHospital_id() );
            tmp.setHospital( hospital.getName() );
            ret.add( tmp );
        }
        return ret;
    }

    @Override
    public List<ArrangeDto> getAllTimeByDoctorAndDay(String day, String doctor)
    {
        List<ArrangeDto> ret = new ArrayList<>();
        List<Arrange> one = mArrangeDao.findAllByDayAndDoctor_id(day, doctor);

        for (int i = 0; i < one.size(); i++) {
            ArrangeDto tmp = new ArrangeDto();
            tmp.setArrange_id( one.get(i).getArrange_id() );
            tmp.setDoctor_id( one.get(i).getDoctor_id() );
            tmp.setTime( one.get(i).getTime() );
            tmp.setLeft_ctn( one.get(i).getLeft_ctn() );
            tmp.setDay( one.get(i).getDay() );
            ret.add(tmp);
        }
        return ret;
    }
}
