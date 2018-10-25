package com.likai.chapter01.practice;

/**
 * Created by likai on 2018/09/19.
 */
public class Student extends Person {
    private String school ;

    public Student() {
        super();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "姓名:" + getName() + ",年龄:" + getAge() + ",学校:" + this.school ;
    }

    public static void main(String [] args) {
        Student s1 = new Student() ;
        s1.setName("李凯");
        s1.setAge(22);
        s1.setSchool("清华") ;

        System.out.println(s1);
    }
}
