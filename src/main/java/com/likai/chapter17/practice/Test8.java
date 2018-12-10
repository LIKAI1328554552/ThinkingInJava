package com.likai.chapter17.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test8 {

    static List<String> list = Arrays.asList("one two three four five six seven eight one".split(" ")) ;
    public static void main(String [] args) {
        System.out.println(list);
        //disjoint(collection,collection) 两个集合没有任何相同的元素时返回true
        //singleton(T x)/singletonList(T x)/singletonMap(K key,V value) 产生不可变的Set/List/Map 他们只包含单一一项
        System.out.println(Collections.disjoint(list,Collections.singletonList("four")));

        //如果要使用max或者min方法此对象必须要实现Comparable接口
        //max(list) min(list) 使用自然比较法进行比较
        //max(list,Comparator) min(list,Comparator) 使用自定义比较器比较Comparator
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list,String.CASE_INSENSITIVE_ORDER));
        System.out.println(Collections.min(list,String.CASE_INSENSITIVE_ORDER));


        List<String> subList = Arrays.asList("four five six".split(" ")) ;

        //indexOfSubList(list,subList) 返回sub集合在集合中第一次出现的位置(找不到返回-1)
        System.out.println(Collections.indexOfSubList(list,subList));

        //lastIndexOfSubList(list,subList) 返回sub集合在集合中最后一次出现的位置(找不到返回-1)
        System.out.println(Collections.lastIndexOfSubList(list,subList));

        //replaceAll(list,oldVal,newVal) 替换集合中值为oldVal的全部元素为newVal
        Collections.replaceAll(list,"one","One") ;
        System.out.println(list);

        //reverse(list) 逆转元素顺序
        Collections.reverse(list);
        System.out.println(list);

        //rotate(list,distance) 所有元素向后移动distance个位置 后面的元素循环到前面来 例如 distance= 2  1 2 3 4 5 6  ->  5 6 1 2 3 4
        Collections.rotate(list,3);
        System.out.println(list);

        List<String> source = Arrays.asList("in the matrix".split(" ")) ;
        //copy(list1,list2) 将list2中的元素复制到list1中 从0位置开始
        Collections.copy(list,source);
        System.out.println(list);

        //swap(list,index1,index2) 将index1与index2索引的元素调换位置 (效率比较高)
        Collections.swap(list,0,list.size() - 1);
        System.out.println(list);

        //shuffle(list) 随机改变list的顺序
        //shuffle(list,Random) 自定义该表list的顺序
        Collections.shuffle(list,new Random(47));
        System.out.println(list);

        //fill(list,obj) 使用obj填充满集合
        Collections.fill(list,"pop");
        System.out.println(list);

        //frequency(list,obj) 返回list中obj的数量
        int sum = Collections.frequency(list,"pop") ;
        System.out.println(sum);

        //nCopies(size,obj) 返回一个大小为n的List 此list不可改变 其中所有引用都指向obj
        List<String> dups = Collections.nCopies(3,"snap") ;
        System.out.println(dups);


    }

}
