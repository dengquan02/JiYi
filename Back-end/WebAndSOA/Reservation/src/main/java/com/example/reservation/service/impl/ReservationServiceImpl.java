package com.example.reservation.service.impl;

import com.example.reservation.entity.Reservation;
import com.example.reservation.dao.ReservationDao;
import com.example.reservation.service.ReservationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Reservation)表服务实现类
 *
 * @author makejava
 * @since 2022-05-15 08:21:47
 */
@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {
    @Resource
    private ReservationDao reservationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param reservationId 主键
     * @return 实例对象
     */
    @Override
    public Reservation queryById(Integer reservationId) {
        return this.reservationDao.queryById(reservationId);
    }

    @Override
    public List<Reservation> queryFreeByPatient(Integer rState) {
        return this.reservationDao.queryFreeByPatient(rState);
    }

    @Override
    public List<Reservation> queryBusyByPatient(String patientId) {
        return this.reservationDao.queryBusyByPatient(patientId);
    }

    @Override
    public List<Reservation> queryByDoctor(String doctorId, Integer rState) {
        return this.reservationDao.queryByDoctor(doctorId,rState);
    }

    @Override
    public List<Reservation> queryByHospital(Integer hospitalId, Integer rState) {
        return this.reservationDao.queryByHospital(hospitalId,rState);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Reservation> queryAllByLimit(int offset, int limit) {
        return this.reservationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param reservation 实例对象
     * @return 实例对象
     */
    @Override
    public Reservation insert(Reservation reservation) {
        this.reservationDao.insert(reservation);
        return reservation;
    }

    /**
     * 修改数据
     *
     * @param reservation 实例对象
     * @return 实例对象
     */
    @Override
    public Reservation update(Reservation reservation) {
        this.reservationDao.update(reservation);
        return this.queryById(reservation.getReservationId());
    }

    /**
     * 通过主键删除数据
     *
     * @param reservationId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer reservationId) {
        return this.reservationDao.deleteById(reservationId) > 0;
    }
}
