package com.example.reservation.controller;

import com.example.reservation.entity.Reservation;
import com.example.reservation.service.ReservationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (Reservation)表控制层
 *
 * @author makejava
 * @since 2022-05-15 08:21:47
 */
@RestController
@RequestMapping("/reservation")
public class ReservationController {
    /**
     * 服务对象
     */
    @Resource
    private ReservationService reservationService;


    @ApiOperation(value = "查询单条信息", notes = "rState含义：0未预约，1已预约，2已就诊")
    @GetMapping("/queryById/{id}")
    public Object queryById(@PathVariable Integer id) {
    return reservationService.queryById(id);
    }

    @ApiOperation(value = "患者查询已预约信息", notes = "rState含义：0未预约，1已预约，2已就诊")
    @GetMapping("/queryBusyByPatient/{patientId}")
    public Object queryBusyByPatient(@PathVariable String patientId) {
        return reservationService.queryBusyByPatient(patientId);
    }

    @ApiOperation(value = "患者查询可预约信息", notes = "")
    @GetMapping("/queryFreeByPatient")
    public Object queryBusyByPatient() throws Exception{
        List list=new ArrayList();
        List<Reservation> reservations = reservationService.queryFreeByPatient(0);
        for (Reservation reservation:reservations){
            Integer rYear=reservation.getRYear();

            Integer rMonth=reservation.getRMonth();

            Integer rDay=reservation.getRDay();

            Integer rHour=reservation.getRHour();

            Integer rMinute=reservation.getRMinute();
//        String dateStr=rYear
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String dateStr = rYear+"-"+rMonth+"-"+rDay+" "+rHour+":"+rMinute;
            Date date = simpleDateFormat.parse(dateStr);
            Date d=new Date();
            if ((date.getTime()-d.getTime())<0){
                reservation.setRState(4);
                reservationService.update(reservation);
            }
        }
        return reservationService.queryFreeByPatient(0);
    }
    @ApiOperation(value = "医生查询所有号", notes = "rState含义：0未预约，1已预约，2已就诊，4过期未预约")
    @GetMapping("/queryAllByDoctor/{doctorId}")
    public Object queryAllByDoctor(@PathVariable String doctorId) throws Exception{
        List<Reservation> reservations = reservationService.queryByDoctor(doctorId, 0);
        for (Reservation reservation:reservations){
            Integer rYear=reservation.getRYear();

            Integer rMonth=reservation.getRMonth();

            Integer rDay=reservation.getRDay();

            Integer rHour=reservation.getRHour();

            Integer rMinute=reservation.getRMinute();
//        String dateStr=rYear
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String dateStr = rYear+"-"+rMonth+"-"+rDay+" "+rHour+":"+rMinute;
            Date date = simpleDateFormat.parse(dateStr);
            Date d=new Date();
            if ((date.getTime()-d.getTime())<0){
                reservation.setRState(4);
                reservationService.update(reservation);
            }
        }
        List list=new ArrayList();
        list.addAll(reservationService.queryByDoctor(doctorId, 0));
        list.addAll(reservationService.queryByDoctor(doctorId,1));
        list.addAll(reservationService.queryByDoctor(doctorId,2));
        list.addAll(reservationService.queryByDoctor(doctorId,4));
        return list;
    }
    @ApiOperation(value = "医生查询已预约号", notes = "rState含义：0未预约，1已预约，2已就诊")
    @GetMapping("/queryBusyByDoctor/{doctorId}")
    public Object queryBusyByDoctor(@PathVariable String doctorId) {
        return reservationService.queryByDoctor(doctorId,1);
    }

    @ApiOperation(value = "医生查询已就诊号", notes = "rState含义：0未预约，1已预约，2已就诊")
    @GetMapping("/queryHasByDoctor/{doctorId}")
    public Object queryHasByDoctor(@PathVariable String doctorId) {
        return reservationService.queryByDoctor(doctorId,2);
    }

//    @ApiOperation(value = "医生查询预约时间到号", notes = "rState含义：0未预约，1已预约，2已就诊")
//    @GetMapping("/queryPassByDoctor/{doctorId}")
//    public Object queryPassByDoctor(@PathVariable String doctorId) {
//        return reservationService.queryByDoctor(doctorId,3);
//    }

    @ApiOperation(value = "按医院可预约信息", notes = "rState含义：0未预约，1已预约，2已就诊")
    @GetMapping("/queryFreeByHospital/{hospitalId}")
    public Object queryFreeByHospital(@PathVariable Integer hospitalId) throws  Exception{
        List<Reservation> reservations = reservationService.queryByHospital(hospitalId, 0);
        for (Reservation reservation:reservations){
            Integer rYear=reservation.getRYear();

            Integer rMonth=reservation.getRMonth();

            Integer rDay=reservation.getRDay();

            Integer rHour=reservation.getRHour();

            Integer rMinute=reservation.getRMinute();
//        String dateStr=rYear
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String dateStr = rYear+"-"+rMonth+"-"+rDay+" "+rHour+":"+rMinute;
            Date date = simpleDateFormat.parse(dateStr);
            Date d=new Date();
            if ((date.getTime()-d.getTime())<0){
                reservation.setRState(4);
                reservationService.update(reservation);
            }
        }
        return reservationService.queryByHospital(hospitalId,0);
    }

    @ApiOperation(value = "进行预约", notes = "")
    @PostMapping("/res")
    public Object queryFreeByHospital(@RequestParam Integer resId,@RequestParam String patientId) throws  Exception{
        Reservation reservation = reservationService.queryById(resId);
        Integer rYear=reservation.getRYear();

        Integer rMonth=reservation.getRMonth();

        Integer rDay=reservation.getRDay();

        Integer rHour=reservation.getRHour();

        Integer rMinute=reservation.getRMinute();
//        String dateStr=rYear
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateStr = rYear+"-"+rMonth+"-"+rDay+" "+rHour+":"+rMinute;
        Date date = simpleDateFormat.parse(dateStr);
        Date d=new Date();
        if ((date.getTime()-d.getTime())<0){
            reservation.setRState(4);
            reservationService.update(reservation);
            return -1;
        }
        reservation.setPatientId(patientId);
        reservation.setRState(1);
        Date mydate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        reservation.setSysTime(formatter.format(mydate));
        return reservationService.update(reservation);
    }

    @ApiOperation(value = "录入", notes = "-1，不能录入比当前时间以前的时间")
    @PostMapping("/upload")
    public Object upload(@RequestParam String doctorId,@RequestParam Integer hospitalId,@RequestParam Integer departmentId,
                         Integer[] year,Integer[] month,Integer[] day,Integer[] hour,Integer[] minute) throws  Exception{
        int len=year.length;
        for(int i=0;i<len;i++){
//            Reservation reservation=new Reservation();
            Integer rYear=year[i];

            Integer rMonth=month[i];

            Integer rDay=day[i];

            Integer rHour=hour[i];

            Integer rMinute=minute[i];
//        String dateStr=rYear
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String dateStr = rYear+"-"+rMonth+"-"+rDay+" "+rHour+":"+rMinute;
            Date date = simpleDateFormat.parse(dateStr);
            Date d=new Date();
            if ((date.getTime()-d.getTime())<0){
                return -1;
            }
        }
        for(int i=0;i<len;i++) {
            Reservation reservation=new Reservation();
            reservation.setDoctorId(doctorId);
            reservation.setRState(0);
            reservation.setHospitalId(hospitalId);
            reservation.setDepartmentId(departmentId);
            reservation.setRYear(year[i]);
            reservation.setRMonth(month[i]);
            reservation.setRDay(day[i]);
            reservation.setRHour(hour[i]);
            reservation.setRMinute(minute[i]);
            reservationService.insert(reservation);
        }
        return 1;
    }

    @ApiOperation(value = "患者取消预约", notes = "-1无此订单，-2时间已过，1成功")
    @PostMapping("/delete")
    public Object delete(@RequestParam String patientId,@RequestParam Integer rId) throws  Exception{
        List<Reservation> reservations = reservationService.queryBusyByPatient(patientId);
        for(Reservation reservation:reservations){
            if (reservation.getReservationId()==rId){
                Integer rYear=reservation.getRYear();

                Integer rMonth=reservation.getRMonth();

                Integer rDay=reservation.getRDay();

                Integer rHour=reservation.getRHour();

                Integer rMinute=reservation.getRMinute();
//        String dateStr=rYear
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String dateStr = rYear+"-"+rMonth+"-"+rDay+" "+rHour+":"+rMinute;
                Date date = simpleDateFormat.parse(dateStr);
                Date d=new Date();
                if ((date.getTime()-d.getTime())<0){
                    return -2;
                }else{
                    reservation.setRState(0);
                    reservation.setPatientId(null);
                    reservation.setSysTime(null);
                    reservationService.update(reservation);
                    return 1;
                }
            }
        }
        return -1;
    }
}
