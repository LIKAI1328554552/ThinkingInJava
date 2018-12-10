package com.likai.chapter17.practice;

import java.util.*;

/**
 * Created by likai on 2018/11/29.
 * Collections 工具类使用
 */
class Student implements Comparable{
    private int a ;
    public Student(int a) {
        this.a = a ;
    }

    public int getA() {
        return this.a ;
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student) o ;
        if(this.a > s.getA()) {
            return 1 ;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        Student s = (Student) obj ;
        if(this.a == s.getA()) {
            return true ;
        } else {
            return false ;
        }
    }

    @Override
    public String toString() {
        return "Studnet: " + this.a ;
    }
}
public class Countries {
    public static void main(String [] args) {
        Collection<String> c = new ArrayList<String>() ;
        c.addAll(Arrays.asList("1","2","3")) ;
        c.add("4") ;
        System.out.println(c);

        Object [] array = c.toArray() ;
        //将一个集合转成对象数组
        String [] str = c.toArray(new String[0]) ;

        Collection<Student> s = new ArrayList<Student>() ;
        s.add(new Student(1)) ;
        s.add(new Student(2)) ;
        s.add(new Student(3)) ;
        s.add(new Student(4)) ;
        s.add(new Student(5)) ;
        //如果要使用max或者min方法此对象必须要实现Comparable接口
        System.out.println(Collections.max(s).getA());
        System.out.println(Collections.min(s).getA());

        Collection<String> c2 = new ArrayList<String>() ;
        c2.addAll(Arrays.asList("1","2","3","4","5")) ;
        //追加
        c.addAll(c2) ;

        System.out.println(c);
        // 删除匹配到的第一个元素
        c.remove("1") ;

        System.out.println(c);
        //此方法使用equals进行比较
        s.remove(new Student(4));

        System.out.println(s);
        //删除c中所有c2相同的元素(同样使用equals比较)
        c.removeAll(c2) ;
        System.out.println(c);

        c.addAll(c2) ;

        System.out.println(c);

        //判断元素是否在集合中
        boolean contains = s.contains(new Student(2));
        System.out.println(contains);
        Collection<Student> cs = new ArrayList<>() ;
        cs.addAll(s) ;
        /*cs.add(new Student(7)) ;*/
        cs.remove(new Student(3)) ;
        //cs中的集合是否为s的子集
        boolean b = s.containsAll(cs);
        System.out.println(b);
        //清空所有元素
        s.clear();
        System.out.println(s);


    }
}
