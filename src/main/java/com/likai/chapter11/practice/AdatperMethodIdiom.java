package com.likai.chapter11.practice;

import java.util.*;

/**
 * Created by likai on 2018/10/23.
 */
class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList() {
    }

    public ReversibleArrayList(Collection<T> collection) {
        super(collection);
    }

    public Iterable<T> reverse() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1 ;
                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public T next() {
                        return get(current --);
                    }

                    @Override
                    public void remove() {

                    }
                };
            }
        } ;
    }
}

public class AdatperMethodIdiom{
    public static void main(String [] args) {
        ReversibleArrayList<String> ral = new ReversibleArrayList<>(Arrays.asList("To be or not to be".split(" "))) ;
        for (String s : ral) {
            System.out.println(s);
        }

        for (String s : ral.reverse()) {
            System.out.println(s);
        }
    }
}
