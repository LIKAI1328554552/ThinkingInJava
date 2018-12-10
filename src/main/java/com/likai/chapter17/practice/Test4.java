package com.likai.chapter17.practice;

import com.likai.data_structure.MyStack;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * set
 */

class SetType {
    int i ;
    public SetType() {
        super() ;
    }

    public SetType(int i) {
        this.i = i ;
    }

    public boolean equals(Object obj) {
        return obj instanceof SetType && (this.i == ((SetType) obj).i) ;
    }

    public String toString() {
        return Integer.toString(this.i) ;
    }
}

class HashType extends SetType {
    public HashType(int i) {
        this.i = i ;
    }

    public int hashCode() {
        return this.i ;
    }
}

class TreeType extends SetType implements Comparable {

    public TreeType(int i) {
        this.i = i ;
    }

    @Override
    public int compareTo(Object o) {
        TreeType type = (TreeType) o ;
        return this.i == type.i ? 0 : (this.i > type.i ? 1 : -1);
    }
}

public class Test4 {
    public static void main(String [] args) {
        //setType仅仅重写了equals方法 没有重写 hashCode方法 因此无法区分同样的数据 输出的结果为 三个对象
        Set<SetType> mySet = new HashSet<SetType>() ;
        mySet.add(new SetType(1)) ;
        mySet.add(new SetType(2)) ;
        mySet.add(new SetType(2)) ;

        System.out.println(mySet);

        System.out.println("---------------------------");

        //HashType equals方法继承于setType 又重写 hashCode方法 区分同样的数据 输出的结果为 两个对象
        Set<HashType> myHashSet = new HashSet<HashType>() ;
        myHashSet.add(new HashType(1)) ;
        myHashSet.add(new HashType(2)) ;
        myHashSet.add(new HashType(2)) ;

        System.out.println(myHashSet);


        System.out.println("---------------------------");

        // TreeType 实现 Comparable接口 进而也可以区分重复数据
        Set<TreeType> treeTypes = new TreeSet<>() ;
        treeTypes.add(new TreeType(8)) ;
        treeTypes.add(new TreeType(77)) ;
        treeTypes.add(new TreeType(34567)) ;
        treeTypes.add(new TreeType(2)) ;
        treeTypes.add(new TreeType(2)) ;

        System.out.println(treeTypes);

        System.out.println(((TreeSet<TreeType>) treeTypes).first());
    }

}
