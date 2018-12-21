package com.likai.util;

import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student {
    private String name ;
    private String age ;
    private String studentID ;

    public Student() {
        super();
    }

    public Student(String name, String age, String studentID) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}

public class JsonTest {

    @Test
    public void test1() {
        Map<String,String> map = new HashMap<String,String>() ;

        map.put("time","1543113329744") ;
        map.put("personIds","19") ;
        map.put("opUserUuid","5b2eb534696b11e89c2e438f92627767") ;
        map.put("pageNo","1") ;
        map.put("pageSize","100") ;
        map.put("appkey","03f2035c") ;
        //map转json
        String json = FastJsonUtil.collectToString(map) ;

        System.out.println(json);
    }

    @Test
    public void test2() {
        String json = "{\"opUserUuid\":\"5b2eb534696b11e89c2e438f92627767\",\"pageNo\":\"1\",\"personIds\":\"19\",\"pageSize\":\"100\",\"appkey\":\"03f2035c\",\"time\":\"1543113329744\"}" ;

        Map<?, ?> map = FastJsonUtil.stringToCollect(json) ;
        for (Object o : map.keySet()) {
            String key = (String) o ;
            System.out.println(map.get(o));
        }
    }

    @Test
    public void test3() {
        List<String> list = new ArrayList<String>() ;

        list.add("1") ;
        list.add("2") ;
        list.add("3") ;
        list.add("4") ;
        list.add("5") ;
        list.add("6") ;
        list.add("7") ;

        String json = FastJsonUtil.toJSONString(list) ;
        System.out.println(json);

        List<Student> sList = new ArrayList<Student>() ;
        sList.add(new Student("likai","1","101")) ;
        sList.add(new Student("lixinyi","2","102")) ;
        sList.add(new Student("lili","3","103")) ;

        String sJson = FastJsonUtil.toJSONString(sList) ;
        System.out.println(sJson);

    }
    @Test
    public void test4() {
        String json = "[\n" +
                "\t{\n" +
                "\t\t\"age\":\"1\",\n" +
                "\t\t\"name\":\"likai\",\n" +
                "\t\t\"studentID\":\"101\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"age\":\"2\",\n" +
                "\t\t\"name\":\"lixinyi\",\n" +
                "\t\t\"studentID\":\"102\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"age\":\"3\",\n" +
                "\t\t\"name\":\"lili\",\n" +
                "\t\t\"studentID\":\"103\"\n" +
                "\t}\n" +
                "]\n" ;

        List<Student> list = FastJsonUtil.toList(json,Student.class) ;

        for (Student student : list) {
            System.out.println(student.getName());
        }
    }

}
