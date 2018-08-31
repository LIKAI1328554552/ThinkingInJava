package com.likai.chapter01.practice;

/**
 * Created by likai on 2018/08/01.
 */
public class ATypeName {
    private String id ;
    private String name ;

    public ATypeName() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ATypeName{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String [] args) {
        ATypeName type = new ATypeName() ;
        type.setId("1");
        type.setName("测试");
        System.out.println(type.toString());
    }
}
