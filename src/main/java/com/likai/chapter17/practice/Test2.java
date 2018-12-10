package com.likai.chapter17.practice;

import java.util.*;

public class Test2 {

    public static void main(String [] args) {
        /*List<String> list = new ArrayList<String>(Arrays.asList("A B C D E F G H I J K L M N O".split(" "))) ;

        Iterator<String> iter = list.iterator() ;
        while(iter.hasNext()) {
            String s = iter.next() ;
            System.out.println(s);
        }*/

        List<String> arrayList = new ArrayList<String>(Arrays.asList("A C E G I K M O".split(" "))) ;
        List<String> linkedList = new LinkedList<String>(Arrays.asList("B D F H J L N".split(" "))) ;

        System.out.println(arrayList);
        System.out.println(linkedList);

        Iterator<String> iter1 = arrayList.iterator() ;
        /*while(iter1.hasNext()) {
            String s = iter1.next() ;
            System.out.println(s);
        }*/


        Iterator<String> iter2 = linkedList.iterator() ;
        /*while(iter2.hasNext()) {
            String s = iter2.next() ;
            System.out.println(s);
        }*/
        // 结果为 [B, A, D, C, F, E, H, G, J, I, L, K, N, M, O] 因此可以发现迭代器 最初是指向第一个元素的前一个位置的
        ListIterator<String> iter3 = arrayList.listIterator() ;
        ListIterator<String> iter4 = linkedList.listIterator() ;
        while(iter4.hasNext()) {
            iter3.add(iter4.next()) ;
            iter3.next();
        }

        System.out.println(iter3.next());


        System.out.println(arrayList);
        System.out.println(linkedList);


        while (iter3.hasPrevious()) {
            iter4.add(iter3.previous());
            iter4.previous() ;
        }

        System.out.println(arrayList);
        System.out.println(linkedList);


    }
}
