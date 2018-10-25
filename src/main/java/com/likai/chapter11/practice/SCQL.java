package com.likai.chapter11.practice;

import java.util.*;

/**
 * Created by likai on 2018/10/21.
 */
public class SCQL {
    private String [] films = {
            "钢铁侠1",
            "钢铁侠2",
            "钢铁侠3",
            "复仇者联盟1",
            "复仇者联盟2",
            "复仇者联盟3"
    } ;

    private int index ;

    public SCQL() {
        super();
    }

    public String next() {
        String film = films[index] ;
        if(index < film.length()-1) {
            index ++ ;
        } else {
            index = 0 ;
        }

        return film ;
    }

    public static void main(String [] args) {
        String [] strs = new String[20] ;
        List<String> arrayList = new ArrayList<String>() ;
        List<String> linkedList = new LinkedList<String>() ;
        Set<String> hashSet = new HashSet<String>() ;
        Set<String> linkedHashSet = new LinkedHashSet<String>() ;
        Set<String> treeSet = new TreeSet<String>() ;
        SCQL scql = new SCQL() ;

        for(int i = 0 ; i < 20; i ++) {
            String film = scql.next() ;
            strs[i] = film ;
            arrayList.add(film) ;
            linkedList.add(film);
            hashSet.add(film) ;
            linkedHashSet.add(film) ;
            treeSet.add(film);
        }

        System.out.println(strs.toString());
        System.out.println(arrayList.toString());
        System.out.println(linkedList.toString());
        System.out.println(hashSet.toString());
        System.out.println(linkedHashSet.toString());
        System.out.println(treeSet.toString());

    }

}
