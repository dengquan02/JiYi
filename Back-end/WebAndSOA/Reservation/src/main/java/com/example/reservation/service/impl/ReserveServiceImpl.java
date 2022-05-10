package com.example.reservation.service.impl;

import com.example.reservation.dao.ArrangeDao;
import com.example.reservation.dao.ReserveDao;
import com.example.reservation.dao.SearchDoctorDao;
import com.example.reservation.dto.ReserveGetDto;
import com.example.reservation.entity.Arrange;
import com.example.reservation.entity.Reserve;
import com.example.reservation.entity.SearchDoctor;
import com.example.reservation.service.ReserveService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReserveServiceImpl implements ReserveService
{
    final ReserveDao mReserveDao;
    final SearchDoctorDao mSearchDoctorDao;
    final ArrangeDao mArrangeDao;

    @Autowired
    public ReserveServiceImpl(ReserveDao reserveDao, SearchDoctorDao searchDoctorDao, ArrangeDao arrangeDao) {
        this.mReserveDao = reserveDao;
        this.mSearchDoctorDao = searchDoctorDao;
        this.mArrangeDao = arrangeDao;
    }

    @Override
    public ReserveGetDto postReservation(ReserveGetDto dto)
    {
        ModelMapper modelMapper = new ModelMapper();
        // 根据dto映射实体类
        Reserve reserve = modelMapper.map( dto, Reserve.class );
        ReserveGetDto ret = modelMapper.map( mReserveDao.save(reserve), ReserveGetDto.class );
        SearchDoctor doctor = mSearchDoctorDao.findByName( dto.getDoctor() );
        doctor.setReserve_ctn( doctor.getReserve_ctn() + 1 );
        mSearchDoctorDao.save( doctor );

        // 对应日期的left_ctn-1
        Arrange arrange = mArrangeDao.getOne( dto.getArrange_id() );
        arrange.setLeft_ctn( arrange.getLeft_ctn() - 1 );
        mArrangeDao.save( arrange );

        ret.setReservation_id( reserve.getReservation_id());
        return ret;
    }

    @Override
    public ReserveGetDto cancelReserve(ReserveGetDto dto)
    {
        Reserve reserve = mReserveDao.getOne( dto.getReservation_id() );
        reserve.setState( 2 );
        mReserveDao.save( reserve );
        ModelMapper modelMapper = new ModelMapper();
        ReserveGetDto ret = modelMapper.map( reserve, ReserveGetDto.class );
        return ret;
    }

    @Override
    public List<ReserveGetDto> getHistory(String patient)
    {
        List<Reserve> all = mReserveDao.findAllByPatient( patient );
        List<ReserveGetDto> ret = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for( int i = 0; i < all.size(); i++ ) {
            ReserveGetDto tmp = modelMapper.map( all.get(i), ReserveGetDto.class );
            ret.add( tmp );
        }
        return ret;
    }



    @Override
    public Integer delete(ReserveGetDto dto)
    {
        return mReserveDao.deleteByReservation_id( dto.getReservation_id() );
    }
}
