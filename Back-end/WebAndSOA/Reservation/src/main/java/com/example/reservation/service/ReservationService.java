package com.example.reservation.service;

import com.example.reservation.entity.Reservation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Reservation)表服务接口
 *
 * @author makejava
 * @since 2022-05-15 08:21:46
 */
public interface ReservationService {

    /**
     * 通过ID查询单条数据
     *
     * @param reservationId 主键
     * @return 实例对象
     */
    Reservation queryById(Integer reservationId);
    List<Reservation> queryFreeByPatient(Integer rState);

    List<Reservation> queryBusyByPatient(String patientId);

    List<Reservation> queryByDoctor(String doctorId, Integer rState);

    List<Reservation> queryByHospital(Integer hospitalId,Integer rState);
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Reservation> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param reservation 实例对象
     * @return 实例对象
     */
    Reservation insert(Reservation reservation);

    /**
     * 修改数据
     *
     * @param reservation 实例对象
     * @return 实例对象
     */
    Reservation update(Reservation reservation);

    /**
     * 通过主键删除数据
     *
     * @param reservationId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer reservationId);

}
