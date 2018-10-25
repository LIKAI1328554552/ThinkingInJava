package com.likai.chapter11.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by likai on 2018/10/21.
 */
public class Test8 {

    private List<Student> list = new ArrayList<>() ;

    public void addList(Student student) {
        list.add(student) ;
    }

    public Iterator<Student> iterator() {
        return new Iterator<Student>() {
            private int index = 0 ;
            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public Student next() {
                return list.get(index ++);
            }

            @Override
            public void remove() {

            }
        } ;
    }

    public static void main(String [] args) {
        Test8 t = new Test8() ;
        for(int i = 0 ; i < 10; i ++) {
            t.addList(new Student("name" + i));
        }

        /*Iterator<Student> iter = t.iterator() ;
        while(iter.hasNext()) {
            Student s = iter.next() ;
            System.out.println(s);
        }*/
    }

}
