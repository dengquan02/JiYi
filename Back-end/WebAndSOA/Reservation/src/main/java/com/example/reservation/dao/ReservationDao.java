package com.example.reservation.dao;

import com.example.reservation.entity.Reservation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Reservation)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-15 08:21:46
 */
public interface ReservationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param reservationId 主键
     * @return 实例对象
     */
    Reservation queryById(Integer reservationId);

    List<Reservation> queryFreeByPatient(Integer rState);

    List<Reservation> queryBusyByPatient(String patientId);

    List<Reservation> queryByDoctor(@Param("doctorId") String doctorId,@Param("rState") Integer rState);

    List<Reservation> queryByHospital(@Param("hospitalId") Integer hospitalId,@Param("rState") Integer rState);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Reservation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param reservation 实例对象
     * @return 对象列表
     */
    List<Reservation> queryAll(Reservation reservation);

    /**
     * 新增数据
     *
     * @param reservation 实例对象
     * @return 影响行数
     */
    int insert(Reservation reservation);

    /**
     * 修改数据
     *
     * @param reservation 实例对象
     * @return 影响行数
     */
    int update(Reservation reservation);

    /**
     * 通过主键删除数据
     *
     * @param reservationId 主键
     * @return 影响行数
     */
    int deleteById(Integer reservationId);

}
