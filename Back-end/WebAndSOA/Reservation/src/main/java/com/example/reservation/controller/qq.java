package com.example.reservation.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Gu HungJou
 * @date: 2022/5/15 9:41
 * Describe:
 */
public class qq {
    public static void main(String[] args) throws Exception{
        Integer rYear=2022;

       Integer rMonth=5;

        Integer rDay=5;

         Integer rHour=9;

         Integer rMinute=55;
//        String dateStr=rYear
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateStr = rYear+"-"+rMonth+"-"+rDay+" "+rHour+":"+rMinute;
        Date date = simpleDateFormat.parse(dateStr);
        Date d=new Date();
        System.out.println((date.getTime()-d.getTime())>0);
    }
}
