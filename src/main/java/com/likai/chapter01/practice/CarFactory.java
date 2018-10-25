package com.likai.chapter01.practice;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by likai on 2018/09/19.
 */
public class CarFactory {

    public static Car getInstanceCar(String pp) {
        if("benchi".equals(pp)) {
            return new BenChi() ;
        } else {
            return new QqCar() ;
        }
    }

    public static void main(String [] args) {
        String type = "3";
        String kssj = null ;
        String jssj = null ;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
        Calendar c = Calendar.getInstance();
        java.util.Date today = new java.util.Date() ;

        if("1".equals(type)) {
            String date = sdf.format(today) ;
            kssj = date + " 00:00:00" ;
            jssj = date + " 23:59:59" ;
        } else if("2".equals(type)) {
            c.setTime(today);
            //设置每星期的第一天
            c.setFirstDayOfWeek(Calendar.MONDAY);
            //获得当前日期是本周的星期几
            int weekDay = c.get(Calendar.DAY_OF_WEEK) ;

            c.add(Calendar.DATE,c.getFirstDayOfWeek() - weekDay);

            kssj = sdf.format(c.getTime()) + " 00:00:00" ;
            jssj = sdf.format(today) + " 23:59:59" ;
        } else {
            c.set(Calendar.DAY_OF_MONTH,1);
            c.set(Calendar.HOUR_OF_DAY,0);

            kssj = sdf.format(c.getTime()) + " 00:00:00" ;

            jssj = sdf.format(today) + " 23:59:59" ;
        }

    }
}
