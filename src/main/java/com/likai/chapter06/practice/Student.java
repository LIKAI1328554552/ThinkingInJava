package com.likai.chapter06.practice;

/**
 * Created by likai on 2018/08/07.
 */
public class Student extends Person{
    
    private String number ;

    private String schoolName ;

    public Student() {
        Person person = new Person() ;
        person.personPrint();
    }
    
    public void setNumber(String number) {
        this.number = number ;
    }
    
    public String getNumber() {
        return this.number ;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
