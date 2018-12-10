package com.likai.chapter17.practice;

import com.likai.chapter06.practice.Connection;

import javax.xml.soap.Text;
import java.util.*;

/**
 * Created by likai on 2018/11/29.
 * 结合类父接口中方法的使用介绍 以及不可修改长度与不可修改的两个集合介绍
 */
public class Test1 {
    public static void test(String msg, List<String> list) {
        System.out.println("----------"+msg+"------------");

        Collection<String> c = list ;

        Collection<String> subList = list.subList(1,8) ;

        Collection<String> c2 = new ArrayList<>(subList) ;
        try{
            c.retainAll(c2) ;
        } catch (Exception e) {
            System.out.println("retainAll: " + e);
        }

        try{
            c.removeAll(c2) ;
        } catch (Exception e) {
            System.out.println("removeAll: " + e);
        }

        try{
            c.clear(); ;
        } catch (Exception e) {
            System.out.println("clear: " + e);
        }


        try{
            c.add("X") ;
        } catch (Exception e) {
            System.out.println("add: " + e);
        }

        try{
            c.addAll(c2) ;
        } catch (Exception e) {
            System.out.println("addAll: " + e);
        }

        try{
            c.remove("C") ;
        } catch (Exception e) {
            System.out.println("remove: " + e);
        }

        try{
            list.set(0,"X") ;
        } catch (Exception e) {
            System.out.println("list.set: " + e);
        }
    }

    public static void main(String [] args) {
        List<String> l1 = new ArrayList<String>(Arrays.asList("A B C D E F G H I J K L M N O".split(" "))) ;
        List<String> l2  = new ArrayList<String>(Arrays.asList("A B C D E Y U".split(" "))) ;

        l1.retainAll(l2) ;

        System.out.println(l1);
    }


    /*public static void main(String [] args) {

        //Arrays.asList 会生成一个固定大小的集合 因此仅支持那些不会改变集合大小的操作 否则会出现UnsupportedOperationException
        List<String> list = Arrays.asList("A B C D E F G H I J K L M N O".split(" ")) ;

        System.out.println(list.getClass());

        test("Modifiable Copy",new ArrayList<String>(list));

        test("Arrays.asList",list) ;

        //Collections.unmodifiableList 返回一个不可做任何修改的集合
        test("unmodifiableLlist()",Collections.unmodifiableList(new ArrayList(list))) ;
    }*/
}
