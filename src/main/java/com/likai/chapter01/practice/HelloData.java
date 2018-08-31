package com.likai.chapter01.practice;

import java.util.Date;

/**
 * Created by likai on 2018/08/02.
 * @author likai
 * @version 1.0
 * @since 1.8
 */
public class HelloData {

    private Date today = new Date() ;
    private String s = new String("Hello World") ;

    public HelloData() {
        super();
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    /**
     * 重写Object父类的toString方法
     * @return 字符串
     */
    @Override
    public String toString() {
        return "HelloData{" +
                "today=" + today +
                ", s='" + s + '\'' +
                '}';
    }
}
